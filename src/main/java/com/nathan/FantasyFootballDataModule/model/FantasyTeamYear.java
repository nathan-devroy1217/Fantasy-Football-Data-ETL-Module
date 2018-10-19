package com.nathan.FantasyFootballDataModule.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class FantasyTeamYear {

    private Integer year;

    private Integer teamId;

    private Integer draftId;

    private String owner;

    private JSONObject jsonObject = new JSONObject();

    public FantasyTeamYear(Integer year, Integer teamId, Integer draftId, String owner) {
        setYear(year);
        setTeamId(teamId);
        setDraftId(draftId);
        setOwner(owner);
    }

    public FantasyTeamYear() {}

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public JSONObject toJson() {
        jsonObject.put("year", year);
        jsonObject.put("teamId", teamId);
        jsonObject.put("draftId", draftId);
        jsonObject.put("owner", owner);

        return jsonObject;
    }
}
