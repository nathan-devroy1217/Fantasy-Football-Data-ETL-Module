package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class Draft {

    private Integer year;

    public Draft(Integer year) {
        setYear(year);
    }

    public Draft() {
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("year", getYear());
        return object;
    }
}

