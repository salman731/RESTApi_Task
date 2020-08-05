package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class Geo {

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @SerializedName("lat")
    private String Latitude;

    @SerializedName("lng")
    private String Longitude;
}
