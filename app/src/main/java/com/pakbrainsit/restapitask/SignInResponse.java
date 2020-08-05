package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class SignInResponse {

    @SerializedName("status")
    private String Status;

    @SerializedName("message")
    private String Message;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
