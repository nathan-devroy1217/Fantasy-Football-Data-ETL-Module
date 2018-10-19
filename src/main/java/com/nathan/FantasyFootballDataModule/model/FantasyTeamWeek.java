package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class FantasyTeamWeek {

    private Integer teamYearId;

    private Integer week;

    private Integer teamId;

    public FantasyTeamWeek(Integer teamYearId, Integer week, Integer teamId) {
        this.teamYearId = teamYearId;
        this.week = week;
        this.teamId = teamId;
    }

    public FantasyTeamWeek() {}

    public Integer getTeamYearId() {
        return teamYearId;
    }

    public void setTeamYearId(Integer teamYearId) {
        this.teamYearId = teamYearId;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("teamYearId", getTeamYearId());
        object.put("week", getWeek());
        object.put("teamId", getTeamId());

        return object;
    }
}
