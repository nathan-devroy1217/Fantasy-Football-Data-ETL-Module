package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class RosterWeek {

    private Integer playerRosterYearId;

    private Integer week;

    private Integer teamId;

    private Integer playerKey;

    public RosterWeek(Integer playerRosterYearId, Integer week, Integer teamId, Integer playerKey) {
        this.playerRosterYearId = playerRosterYearId;
        this.week = week;
        this.teamId = teamId;
        this.playerKey = playerKey;
    }

    public RosterWeek() {}

    public Integer getPlayerRosterYearId() {
        return playerRosterYearId;
    }

    public void setPlayerRosterYearId(Integer playerRosterYearId) {
        this.playerRosterYearId = playerRosterYearId;
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

    public Integer getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(Integer playerKey) {
        this.playerKey = playerKey;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("playerRosterYearId", getPlayerRosterYearId());
        object.put("week", getWeek());
        object.put("teamId", getTeamId());
        object.put("playerKey", getPlayerKey());

        return object;
    }
}
