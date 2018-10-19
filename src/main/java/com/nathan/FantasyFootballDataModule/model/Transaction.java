package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class Transaction {

    private Integer teamWeekId;

    private String transactionKey;

    private Integer tradeSenderId;

    private Integer tradeReceiverId;

    private Integer playerId;

    private Integer waiverAddPlayerId;

    private Integer waiverDropPlayerId;

    public Transaction(Integer teamWeekId, String transactionKey, Integer tradeSenderId,
                       Integer tradeReceiverId, Integer playerId,
                       Integer waiverAddPlayerId, Integer waiverDropPlayerId) {
        this.teamWeekId = teamWeekId;
        this.transactionKey = transactionKey;
        this.tradeSenderId = tradeSenderId;
        this.tradeReceiverId = tradeReceiverId;
        this.playerId = playerId;
        this.waiverAddPlayerId = waiverAddPlayerId;
        this.waiverDropPlayerId = waiverDropPlayerId;
    }

    public Transaction() {}

    public Integer getTeamWeekId() {
        return teamWeekId;
    }

    public void setTeamWeekId(Integer teamWeekId) {
        this.teamWeekId = teamWeekId;
    }

    public String getTransactionKey() {
        return transactionKey;
    }

    public void setTransactionKey(String transactionKey) {
        this.transactionKey = transactionKey;
    }

    public Integer getTradeSenderId() {
        return tradeSenderId;
    }

    public void setTradeSenderId(Integer tradeSenderId) {
        this.tradeSenderId = tradeSenderId;
    }

    public Integer getTradeReceiverId() {
        return tradeReceiverId;
    }

    public void setTradeReceiverId(Integer tradeReceiverId) {
        this.tradeReceiverId = tradeReceiverId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getWaiverAddPlayerId() {
        return waiverAddPlayerId;
    }

    public void setWaiverAddPlayerId(Integer waiverAddPlayerId) {
        this.waiverAddPlayerId = waiverAddPlayerId;
    }

    public Integer getWaiverDropPlayerId() {
        return waiverDropPlayerId;
    }

    public void setWaiverDropPlayerId(Integer waiverDropPlayerId) {
        this.waiverDropPlayerId = waiverDropPlayerId;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("teamWeekId", getTeamWeekId());
        object.put("transactionKey", getTransactionKey());
        object.put("tradeSenderId", getTradeSenderId());
        object.put("tradeReceiverId", getTradeReceiverId());
        object.put("playerId", getPlayerId());
        object.put("waiverAddPlayerId", getWaiverAddPlayerId());
        object.put("waiverDropPlayerId", getWaiverDropPlayerId());

        return object;
    }
}
