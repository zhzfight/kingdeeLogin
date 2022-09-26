package com.tjkd.tjkderpdisplay;

public class appTokenDAO {
    public appTokenDAO(){

    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecuret() {
        return appSecuret;
    }

    public String getTenantid() {
        return tenantid;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getLanguage() {
        return language;
    }

    public void setAppSecuret(String appSecuret) {
        this.appSecuret = appSecuret;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String appId;
    private String appSecuret;
    private String tenantid;
    private String accountId;
    private String language;
}
