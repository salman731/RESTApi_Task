package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class Address {

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getSuite() {
        return Suite;
    }

    public void setSuite(String suite) {
        Suite = suite;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public Geo getGeoLocation() {
        return GeoLocation;
    }

    public void setGeoLocation(Geo geoLocation) {
        GeoLocation = geoLocation;
    }

    @SerializedName("street")
    private String Street;

    @SerializedName("suite")
    private String Suite;

    @SerializedName("city")
    private String City;

    @SerializedName("zipcode")
    private  String ZipCode;

    @SerializedName("geo")
    private Geo GeoLocation;
}