package com.pakbrainsit.restapitask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.internal.$Gson$Preconditions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email,password;
    private Retrofit retrofit;
    private Button signinBTN;
    private final  String BASE_URL1 = "https://maallik.com/";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = (EditText) findViewById(R.id.signinEmail);
        password = (EditText) findViewById(R.id.signinPassword);
        signinBTN = (Button) findViewById(R.id.signinBTN);
        signinBTN.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing In.....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        retrofit = new RetrofitClient().getRetrofitClient(BASE_URL1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSignIn:
                return true;
            case R.id.menuHome:
                Intent intent2 = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intent2);
                return true;
            case R.id.menuSignUp:
                Intent intent1 = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent1);
                return  true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }


    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(email.getText().toString().trim()) || TextUtils.isEmpty(password.getText().toString().trim()))
        {
            Toast.makeText(getApplicationContext(),"Enter Email or Password....",Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.show();
            RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

            Call<SignInResponse> signInResponseCall = retrofitApi.SignInUser(email.getText().toString().trim(), password.getText().toString().trim());
            signInResponseCall.enqueue(new Callback<SignInResponse>() {
                @Override
                public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                    SignInResponse signInResponse = response.body();
                    if(signInResponse == null)
                    {
                        Toast.makeText(getApplicationContext(), "Please enter valid email and password....", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), signInResponse.getMessage() + " " + signInResponse.getStatus(), Toast.LENGTH_LONG).show();
                        //progressDialog.dismiss();
                        if (signInResponse.getStatus().equals("success") && signInResponse.getMessage().equals("User found.")) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "User Found......", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "Please enter valid email and password....", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<SignInResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}