package com.pakbrainsit.restapitask;

import com.google.gson.annotations.SerializedName;

public class RegisteredUserRespose {

    @SerializedName("status")
    private String Status;

    @SerializedName("message")
    private String Message;

    @SerializedName("data")
    private RegisterUserDetail registerUserDetail;

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

    public RegisterUserDetail getRegisterUserDetail() {
        return registerUserDetail;
    }

    public void setRegisterUserDetail(RegisterUserDetail registerUserDetail) {
        this.registerUserDetail = registerUserDetail;
    }
}
