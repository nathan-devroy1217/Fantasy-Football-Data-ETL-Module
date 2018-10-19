package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class PlayerYear {

    private Integer playerKey;

    private Integer positionKey;

    private Integer nflTeamId;

    private Integer adp;

    private Integer yearKey;

    private JSONObject jsonObject = new JSONObject();

    public PlayerYear(Integer playerKey, Integer positionKey, Integer nflTeamId, Integer adp, Integer yearKey) {
        setPlayerKey(playerKey);
        setPositionKey(positionKey);
        setNflTeamId(nflTeamId);
        setAdp(adp);
        setYearKey(yearKey);
    }

    public PlayerYear() {}

    public Integer getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(Integer playerKey) {
        this.playerKey = playerKey;
    }

    public Integer getPositionKey() {
        return positionKey;
    }

    public void setPositionKey(Integer positionKey) {
        this.positionKey = positionKey;
    }

    public Integer getNflTeamId() {
        return nflTeamId;
    }

    public void setNflTeamId(Integer nflTeamId) {
        this.nflTeamId = nflTeamId;
    }

    public Integer getAdp() {
        return adp;
    }

    public void setAdp(Integer adp) {
        this.adp = adp;
    }

    public Integer getYearKey() {
        return yearKey;
    }

    public void setYearKey(Integer yearKey) {
        this.yearKey = yearKey;
    }

    public JSONObject toJson() {
        jsonObject.put("playerKey", playerKey);
        jsonObject.put("positionKey", positionKey);
        jsonObject.put("nflTeamId", nflTeamId);
        jsonObject.put("adp", adp);
        jsonObject.put("yearKey", yearKey);

        return  jsonObject;
    }
}
