package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    private String Name;

    @SerializedName("username")
    private String Username;

    @SerializedName("email")
    private String Email;

    @SerializedName("phone")
    private String Phone;

    @SerializedName("website")
    private String Website;

    @SerializedName("address")
    private Address Address;

    public com.pakbrainsit.restapitask.Address getAddress() {
        return Address;
    }

    public void setAddress(com.pakbrainsit.restapitask.Address address) {
        Address = address;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
