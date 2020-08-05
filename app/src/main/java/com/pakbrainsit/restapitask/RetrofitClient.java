package com.pakbrainsit.restapitask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

   public  Retrofit retrofit = null;

    public Retrofit getRetrofitClient(String BASE_URL)
    {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }


}
