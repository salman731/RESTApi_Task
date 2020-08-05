package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class NewUser {

    @SerializedName("json")
    private Json json;

    public formdata getData() {
        return data;
    }

    public void setData(formdata data) {
        this.data = data;
    }

    @SerializedName("form")
    private formdata data;

    public Json getJson() {
        return json;
    }

    public void setJson(Json json) {
        this.json = json;
    }





}
