package com.example.chakiri.thetvdb.model;

/**
 * Created by steve on 20/01/2018.
 */

public class Authentication {
    private static final String APIKEY = "DB62F06438565B34";
    private static final String USERKEY = "EABC0AC8756657B2";
    private static final String USERNAME = "chakiri";

    private String apikey;
    private String userkey;
    private String username;

    public Authentication() {
        this.apikey = APIKEY;
        this.userkey = USERKEY;
        this.username = USERNAME;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
