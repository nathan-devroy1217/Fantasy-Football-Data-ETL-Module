package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class DraftRound {

    private Integer id;

    private Integer round;

    private Integer pickNum;

    private Integer team;

    private Integer playerId;

    private Integer year;

    public DraftRound(Integer id, Integer round, Integer pickNum, Integer team, Integer playerId, Integer year) {
        setId(id);
        setRound(round);
        setPickNum(pickNum);
        setTeam(team);
        setPlayerId(playerId);
        setYear(year);
    }

    public DraftRound() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getPickNum() {
        return pickNum;
    }

    public void setPickNum(Integer pickNum) {
        this.pickNum = pickNum;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("id", getId());
        object.put("round", getRound());
        object.put("pickNum", getPickNum());
        object.put("team", getTeam());
        object.put("playerId", playerId);
        object.put("year", getYear());

        return object;
    }
}
