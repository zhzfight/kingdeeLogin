package com.tjkd.tjkderpdisplay;

public class appTokenResponse {
    private String state;
    private appTokenData data;

    public String getState() {
        return state;
    }

    public appTokenData getData() {
        return data;
    }

    public void setData(appTokenData data) {
        this.data = data;
    }

    public void setState(String state) {
        this.state = state;
    }


}
