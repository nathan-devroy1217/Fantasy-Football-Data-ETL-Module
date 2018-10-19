package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class PlayerYearRoster {

    private Integer playerYearId;

    private Integer teamId;

    private String teamName;

    private Integer year;

    public PlayerYearRoster(Integer playerYearId, Integer teamId, String teamName, Integer year) {
        this.playerYearId = playerYearId;
        this.teamId = teamId;
        this.teamName = teamName;
        this.year = year;
    }

    public PlayerYearRoster() {}

    public Integer getPlayerYearId() {
        return playerYearId;
    }

    public void setPlayerYearId(Integer playerYearId) {
        this.playerYearId = playerYearId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("playerYearId", playerYearId);
        object.put("teamId", teamId);
        object.put("teamName", teamName);
        object.put("year", year);

        return object;
    }
}
