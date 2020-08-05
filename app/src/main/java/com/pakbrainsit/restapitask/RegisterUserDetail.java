package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class RegisterUserDetail {

    @SerializedName("id")
    private int ID;

    @SerializedName("email")
    private String Email;

    @SerializedName("name")
    private String Name;

    @SerializedName("city")
    private String City;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
