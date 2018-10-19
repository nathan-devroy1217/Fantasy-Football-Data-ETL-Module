package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class FantasyTeam {

    private String teamName;

    private String owner;

    private JSONObject jsonObject = new JSONObject();

    public FantasyTeam(String teamName, String owner) {
        setOwner(owner);
        setTeamName(teamName);
    }

    public FantasyTeam() {

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public JSONObject toJson() {
        jsonObject.put("owner", owner);
        jsonObject.put("teamName", teamName);

        return jsonObject;
    }
}
