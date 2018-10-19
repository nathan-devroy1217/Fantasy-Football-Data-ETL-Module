package com.nathan.FantasyFootballDataModule.model;

import org.json.simple.JSONObject;

public class Player {

    private String firstName;

    private String lastName;

    private Integer positionKey;

    private JSONObject jsonObject = new JSONObject();

    public Player(String firstName, String lastName, Integer positionKey) {
        setFirstName(firstName);
        setLastName(lastName);
        setPositionKey(positionKey);
    }

    public Player() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPositionKey() {
        return positionKey;
    }

    public void setPositionKey(Integer positionKey) {
        this.positionKey = positionKey;
    }

    public JSONObject toJson() {
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("positionKey", positionKey);

        return jsonObject;
    }
}
