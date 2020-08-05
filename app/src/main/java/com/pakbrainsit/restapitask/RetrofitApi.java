package com.pakbrainsit.restapitask;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitApi {

    @GET("/users")
    Call<List<User>> getALLUsers();

    @POST("/post")
    Call<NewUser> getRegisterUser(@Body Json json);

    @FormUrlEncoded
    @POST("/post")
    Call<NewUser> getRegisterUser(@Field("name") String Name,@Field("username") String Usernam,@Field("isregistered") boolean registerornot );

    @GET("/Android/signup.php")
    Call<RegisteredUserRespose> RegisterUser(@Query("name") String Name, @Query("email") String Email,@Query("password") String Password,@Query("phone") String PhoneNo,@Query("city") String City,@Query("address") String Address,@Query("role") String Role,@Query("proimage") String Proimage);

    @GET("/Android/login.php")
    Call<SignInResponse> SignInUser (@Query("email") String Email, @Query("password") String Password);


}
