package com.tjkd.tjkderpdisplay;

public class accessTokenResponse {
    private accessTokenData data;
    private String state;

    public accessTokenData getData() {
        return data;
    }

    public void setData(accessTokenData data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
