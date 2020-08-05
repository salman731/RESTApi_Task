package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class formdata {


    @SerializedName("name")
    private String Name;

    @SerializedName("username")
    private  String Username;

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    @SerializedName("isregistered")
    private  boolean isRegistered;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public formdata(String name, String username,boolean isregistered ) {
        Name = name;
        Username = username;
        isRegistered = isregistered;
    }


}
