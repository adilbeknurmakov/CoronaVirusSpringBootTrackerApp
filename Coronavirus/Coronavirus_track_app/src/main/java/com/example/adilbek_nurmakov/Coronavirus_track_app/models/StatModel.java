package com.example.adilbek_nurmakov.Coronavirus_track_app.models;

import java.util.Objects;
//Author Adilbek Nurmakov
public class StatModel {
    private String state;
    private String country;
    private int latestReportedCases;
    private int diffFromBeforeDays;

    public int getDiffFromBeforeDays() {
        return diffFromBeforeDays;
    }

    public void setDiffFromBeforeDays(int diffFromBeforeDays) {
        this.diffFromBeforeDays = diffFromBeforeDays;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestReportedCases() {
        return latestReportedCases;
    }

    public void setLatestReportedCases(int latestReportedCases) {
        this.latestReportedCases = latestReportedCases;
    }

    @Override
    public String toString() {
        return "StatModel{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestReportedCases='" + latestReportedCases + '\'' +
                '}';
    }
}
