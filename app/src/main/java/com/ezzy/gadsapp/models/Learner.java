package com.ezzy.gadsapp.models;

import com.google.gson.annotations.SerializedName;

public class Learner {
    @SerializedName("name")
    private String name;
    @SerializedName("hours")
    private String hours;
    @SerializedName("badge_url")
    private String badge_url;

    public Learner(String name, String hours, String badge_url) {
        this.name = name;
        this.hours = hours;
        this.badge_url = badge_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBadge_url() {
        return badge_url;
    }

    public void setBadge_url(String badge_url) {
        this.badge_url = badge_url;
    }
}
