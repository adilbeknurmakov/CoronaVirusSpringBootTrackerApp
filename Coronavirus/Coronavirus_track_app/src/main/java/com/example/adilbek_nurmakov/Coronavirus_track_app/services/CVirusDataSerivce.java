package com.example.adilbek_nurmakov.Coronavirus_track_app.services;

import com.example.adilbek_nurmakov.Coronavirus_track_app.models.StatModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
//Author Adilbek Nurmakov
//Disclaimer: It is bad practise to save state in Service Class (latestCases).
// But in this project it's done for simplicity
@Service
public class CVirusDataSerivce {
    private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<StatModel> allData = new ArrayList<>();

    public List<StatModel> getAllData() {
        return allData;
    }

    @PostConstruct
    @Scheduled(cron="* * 1 * * *")
    public void getData() throws IOException, InterruptedException {
        List<StatModel> newData = new ArrayList<>();
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        StringReader csvResponseReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(csvResponseReader);
        for (CSVRecord record : records) {
            StatModel model = new StatModel();
            model.setState(record.get("Province/State"));
            model.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int prevDays = Integer.parseInt(record.get(record.size()-2));
            model.setLatestReportedCases(latestCases);
            model.setDiffFromBeforeDays(latestCases-prevDays);
            newData.add(model);
        }
        this.allData= newData;
    }
}
