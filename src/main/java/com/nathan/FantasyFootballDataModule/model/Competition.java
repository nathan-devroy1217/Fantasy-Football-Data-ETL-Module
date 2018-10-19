package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class Competition {

    private Integer teamWeekId;

    private Integer week;

    private Integer homeTeamKey;

    private Integer awayTeamKey;

    private Integer homeTeamScore;

    private Integer awayTeamScore;

    public Competition(Integer teamWeekId, Integer week, Integer homeTeamKey,
                       Integer awayTeamKey, Integer homeTeamScore,
                       Integer awayTeamScore) {
        this.teamWeekId = teamWeekId;
        this.week = week;
        this.homeTeamKey = homeTeamKey;
        this.awayTeamKey = awayTeamKey;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public Competition() {}

    public Integer getTeamWeekId() {
        return teamWeekId;
    }

    public void setTeamWeekId(Integer teamWeekId) {
        this.teamWeekId = teamWeekId;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getHomeTeamKey() {
        return homeTeamKey;
    }

    public void setHomeTeamKey(Integer homeTeamKey) {
        this.homeTeamKey = homeTeamKey;
    }

    public Integer getAwayTeamKey() {
        return awayTeamKey;
    }

    public void setAwayTeamKey(Integer awayTeamKey) {
        this.awayTeamKey = awayTeamKey;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("teamWeekId", getTeamWeekId());
        object.put("week", getWeek());
        object.put("homeTeamKey", getHomeTeamKey());
        object.put("awayTeamKey", getAwayTeamKey());
        object.put("homeTeamScore", getHomeTeamScore());
        object.put("awayTeamScore", getAwayTeamScore());

        return object;
    }
}
