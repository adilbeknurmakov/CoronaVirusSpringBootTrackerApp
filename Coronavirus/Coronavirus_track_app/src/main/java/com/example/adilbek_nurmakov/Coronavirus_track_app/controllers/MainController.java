package com.example.adilbek_nurmakov.Coronavirus_track_app.controllers;

import com.example.adilbek_nurmakov.Coronavirus_track_app.models.StatModel;
import com.example.adilbek_nurmakov.Coronavirus_track_app.services.CVirusDataSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//Author Adilbek Nurmakov
@Controller
public class MainController {
    @Autowired
    CVirusDataSerivce cVirusDataSerivce;
    @GetMapping("/")
    public String goHomePage(Model view){
        List<StatModel> allData = cVirusDataSerivce.getAllData();
        int totalCases = allData.stream().mapToInt(stat->stat.getLatestReportedCases()).sum();
        int totalNewCases = allData.stream().mapToInt(stat->stat.getDiffFromBeforeDays()).sum();
        view.addAttribute("statData", cVirusDataSerivce.getAllData());
        view.addAttribute("totalCases", totalCases);
        view.addAttribute("totalNewCases", totalNewCases);
        return "homePg";
    }
}
