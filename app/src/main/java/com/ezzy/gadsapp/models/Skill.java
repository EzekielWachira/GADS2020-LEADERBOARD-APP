package com.ezzy.gadsapp.models;

import com.google.gson.annotations.SerializedName;

public class Skill {
    @SerializedName("name")
    private String name;
    @SerializedName("skills")
    private String skills;
    @SerializedName("badge_url")
    private String badge_url;

    public Skill(String name, String skills, String badge_url) {
        this.name = name;
        this.skills = skills;
        this.badge_url = badge_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getBadge_url() {
        return badge_url;
    }

    public void setBadge_url(String badge_url) {
        this.badge_url = badge_url;
    }
}
