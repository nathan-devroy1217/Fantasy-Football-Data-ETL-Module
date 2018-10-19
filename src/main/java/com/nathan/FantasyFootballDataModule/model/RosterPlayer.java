package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class RosterPlayer {

    private Integer rosterWeekId;

    private Integer playerKey;

    private Integer fantasyPoints;

    private Integer passAttempts;

    private Integer passCompletions;

    private Integer passYds;

    private Integer passTd;

    private Integer interceptions;

    private Integer fumbles;

    private Integer rushAttempts;

    private Integer rushYds;

    private Integer rushTd;

    private Integer plays;

    private Integer wrPassTargets;

    private Integer wrPassRec;

    private Integer wrReceivingYds;

    private Integer tdReceptions;

    private Integer fgMade;

    private Integer fgAttempt;

    private Integer xpMade;

    private Integer xpAttempt;

    private Integer defSack;

    private Integer defFumbleRec;

    private Integer defInt;

    private Integer defTd;

    private Integer defSafety;

    private Integer specTeamsTd;

    public RosterPlayer(Integer rosterWeekId, Integer playerKey, Integer fantasyPoints,
                        Integer passAttempts, Integer passCompletions, Integer passYds,
                        Integer passTd, Integer interceptions, Integer fumbles,
                        Integer rushAttempts, Integer rushYds, Integer rushTd,
                        Integer plays, Integer wrPassTargets, Integer wrPassRec,
                        Integer wrReceivingYds, Integer tdReceptions, Integer fgMade,
                        Integer fgAttempt, Integer xpMade, Integer xpAttempt,
                        Integer defSack, Integer defFumbleRec, Integer defInt,
                        Integer defTd, Integer defSafety, Integer specTeamsTd) {
        this.rosterWeekId = rosterWeekId;
        this.playerKey = playerKey;
        this.fantasyPoints = fantasyPoints;
        this.passAttempts = passAttempts;
        this.passCompletions = passCompletions;
        this.passYds = passYds;
        this.passTd = passTd;
        this.interceptions = interceptions;
        this.fumbles = fumbles;
        this.rushAttempts = rushAttempts;
        this.rushYds = rushYds;
        this.rushTd = rushTd;
        this.plays = plays;
        this.wrPassTargets = wrPassTargets;
        this.wrPassRec = wrPassRec;
        this.wrReceivingYds = wrReceivingYds;
        this.tdReceptions = tdReceptions;
        this.fgMade = fgMade;
        this.fgAttempt = fgAttempt;
        this.xpMade = xpMade;
        this.xpAttempt = xpAttempt;
        this.defSack = defSack;
        this.defFumbleRec = defFumbleRec;
        this.defInt = defInt;
        this.defTd = defTd;
        this.defSafety = defSafety;
        this.specTeamsTd = specTeamsTd;
    }

    public RosterPlayer() {}

    public Integer getRosterWeekId() {
        return rosterWeekId;
    }

    public void setRosterWeekId(Integer rosterWeekId) {
        this.rosterWeekId = rosterWeekId;
    }

    public Integer getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(Integer playerKey) {
        this.playerKey = playerKey;
    }

    public Integer getFantasyPoints() {
        return fantasyPoints;
    }

    public void setFantasyPoints(Integer fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

    public Integer getPassAttempts() {
        return passAttempts;
    }

    public void setPassAttempts(Integer passAttempts) {
        this.passAttempts = passAttempts;
    }

    public Integer getPassCompletions() {
        return passCompletions;
    }

    public void setPassCompletions(Integer passCompletions) {
        this.passCompletions = passCompletions;
    }

    public Integer getPassYds() {
        return passYds;
    }

    public void setPassYds(Integer passYds) {
        this.passYds = passYds;
    }

    public Integer getPassTd() {
        return passTd;
    }

    public void setPassTd(Integer passTd) {
        this.passTd = passTd;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Integer getFumbles() {
        return fumbles;
    }

    public void setFumbles(Integer fumbles) {
        this.fumbles = fumbles;
    }

    public Integer getRushAttempts() {
        return rushAttempts;
    }

    public void setRushAttempts(Integer rushAttempts) {
        this.rushAttempts = rushAttempts;
    }

    public Integer getRushYds() {
        return rushYds;
    }

    public void setRushYds(Integer rushYds) {
        this.rushYds = rushYds;
    }

    public Integer getRushTd() {
        return rushTd;
    }

    public void setRushTd(Integer rushTd) {
        this.rushTd = rushTd;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
    }

    public Integer getWrPassTargets() {
        return wrPassTargets;
    }

    public void setWrPassTargets(Integer wrPassTargets) {
        this.wrPassTargets = wrPassTargets;
    }

    public Integer getWrPassRec() {
        return wrPassRec;
    }

    public void setWrPassRec(Integer wrPassRec) {
        this.wrPassRec = wrPassRec;
    }

    public Integer getWrReceivingYds() {
        return wrReceivingYds;
    }

    public void setWrReceivingYds(Integer wrReceivingYds) {
        this.wrReceivingYds = wrReceivingYds;
    }

    public Integer getTdReceptions() {
        return tdReceptions;
    }

    public void setTdReceptions(Integer tdReceptions) {
        this.tdReceptions = tdReceptions;
    }

    public Integer getFgMade() {
        return fgMade;
    }

    public void setFgMade(Integer fgMade) {
        this.fgMade = fgMade;
    }

    public Integer getFgAttempt() {
        return fgAttempt;
    }

    public void setFgAttempt(Integer fgAttempt) {
        this.fgAttempt = fgAttempt;
    }

    public Integer getXpMade() {
        return xpMade;
    }

    public void setXpMade(Integer xpMade) {
        this.xpMade = xpMade;
    }

    public Integer getXpAttempt() {
        return xpAttempt;
    }

    public void setXpAttempt(Integer xpAttempt) {
        this.xpAttempt = xpAttempt;
    }

    public Integer getDefSack() {
        return defSack;
    }

    public void setDefSack(Integer defSack) {
        this.defSack = defSack;
    }

    public Integer getDefFumbleRec() {
        return defFumbleRec;
    }

    public void setDefFumbleRec(Integer defFumbleRec) {
        this.defFumbleRec = defFumbleRec;
    }

    public Integer getDefInt() {
        return defInt;
    }

    public void setDefInt(Integer defInt) {
        this.defInt = defInt;
    }

    public Integer getDefTd() {
        return defTd;
    }

    public void setDefTd(Integer defTd) {
        this.defTd = defTd;
    }

    public Integer getDefSafety() {
        return defSafety;
    }

    public void setDefSafety(Integer defSafety) {
        this.defSafety = defSafety;
    }

    public Integer getSpecTeamsTd() {
        return specTeamsTd;
    }

    public void setSpecTeamsTd(Integer specTeamsTd) {
        this.specTeamsTd = specTeamsTd;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("rosterWeekId", getRosterWeekId());
        object.put("playerKey", getPlayerKey());
        object.put("fantasyPoints", getFantasyPoints());
        object.put("passAttempts", getPassAttempts());
        object.put("passCompletions", getPassCompletions());
        object.put("passYds", getPassYds());
        object.put("passTd", getPassTd());
        object.put("interceptions", getInterceptions());
        object.put("fumbles", getFumbles());
        object.put("rushAttempts", getRushAttempts());
        object.put("rushYds", getRushYds());
        object.put("rushTd", getRushTd());
        object.put("plays", getPlays());
        object.put("wrPassTargets", getWrPassTargets());
        object.put("wrPassRec", getWrPassRec());
        object.put("wrReceivingYds", getWrReceivingYds());
        object.put("tdReceptions", getTdReceptions());
        object.put("fgMade", getFgMade());
        object.put("fgAttempt", getFgAttempt());
        object.put("xpMade", getXpMade());
        object.put("xpAttempt", getXpAttempt());
        object.put("defSack", getDefSack());
        object.put("defFumbleRec", getDefFumbleRec());
        object.put("defInt", getDefInt());
        object.put("defTd", getDefTd());
        object.put("defSafety", getDefSafety());
        object.put("specTeamsTd", getSpecTeamsTd());

        return object;
    }
}
