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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Map;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {


    private EditText etName,etPhone,etPassword,etemail,etCity,etAddress,etRole,etProimage;
    private TextView tvMessage;
    private Retrofit retrofit;
    private static final String BASE_URL2 = "https://maallik.com/";
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName = (EditText) findViewById(R.id.Name);
        etPhone = (EditText) findViewById(R.id.PhoneNo);
        etemail = (EditText) findViewById(R.id.Email);
        etPassword= (EditText) findViewById(R.id.Password);
        etCity= (EditText) findViewById(R.id.City);
        etAddress= (EditText) findViewById(R.id.Address);
        etRole= (EditText) findViewById(R.id.Role);
        etProimage= (EditText) findViewById(R.id.Proimage);
        tvMessage = (TextView) findViewById(R.id.ResposeMessage);
        retrofit = new RetrofitClient().getRetrofitClient(BASE_URL2);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering User.....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);



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
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);

                return true;
            case R.id.menuHome:
                Intent intent2 = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent2);
            case R.id.menuSignUp:
                return  true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    public void SignUpClick(View view)
    {

        if(TextUtils.isEmpty(etName.getText().toString().trim()) || TextUtils.isEmpty(etemail.getText().toString().trim()) || TextUtils.isEmpty(etPassword.getText().toString().trim()) || TextUtils.isEmpty(etPhone.getText().toString().trim()) || TextUtils.isEmpty(etCity.getText().toString().trim()) || TextUtils.isEmpty(etAddress.getText().toString().trim()) || TextUtils.isEmpty(etRole.getText().toString().trim()) || TextUtils.isEmpty(etProimage.getText().toString().trim()))
        {
            Toast.makeText(getApplicationContext(),"Fill all fields.....",Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.show();
            RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
            Call<RegisteredUserRespose> callRegisterUser = retrofitApi.RegisterUser(etName.getText().toString().trim(), etemail.getText().toString().trim(), etPassword.getText().toString().trim(), etPhone.getText().toString().trim(), etCity.getText().toString().trim(), etAddress.getText().toString().trim(), etRole.getText().toString().trim(), etProimage.getText().toString().trim());

            callRegisterUser.enqueue(new Callback<RegisteredUserRespose>() {
                @Override
                public void onResponse(Call<RegisteredUserRespose> call, Response<RegisteredUserRespose> response) {
                    try {
                        RegisteredUserRespose registeredUserRespose = response.body();
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Status :" + registeredUserRespose.getStatus() + " Message : " + registeredUserRespose.getMessage(), Toast.LENGTH_LONG).show();
                        tvMessage.setText("ID : " + registeredUserRespose.getRegisterUserDetail().getID() + "\n" + "Name : " + registeredUserRespose.getRegisterUserDetail().getName() + "\n" +
                                "Email : " + registeredUserRespose.getRegisterUserDetail().getEmail() + "\n" + "City : " + registeredUserRespose.getRegisterUserDetail().getCity());

                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<RegisteredUserRespose> call, Throwable t) {

                }
            });
        }
   // POST DATA IN FORM OF RAW
       /* Call<NewUser> call = retrofitApi.getRegisterUser(new Json(etName.getText().toString().trim(),etemail.getText().toString().trim(),etUsername.getText().toString().trim(),etPassword.getText().toString().trim()));

        call.enqueue(new Callback<NewUser>() {
            @Override
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                NewUser newUser = response.body();
                Toast.makeText(getApplicationContext(),newUser.getJson().getName() +" "+newUser.getJson().getEmail(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<NewUser> call, Throwable t) {

            }
        }); */


       //POST DATA IN FORM OF FORM DATA
       /* Call<NewUser> call = retrofitApi.getRegisterUser(etName.getText().toString().trim(), etUsername.getText().toString().trim(),true);

        call.enqueue(new Callback<NewUser>() {
            @Override
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                NewUser newUser = response.body();
                if(newUser.getData().isRegistered())
                {
                    Toast.makeText(getApplicationContext(),"User registerd successfully......",Toast.LENGTH_LONG ).show();

                }
            }

            @Override
            public void onFailure(Call<NewUser> call, Throwable t) {

                t.printStackTrace();
                Toast.makeText(getApplicationContext(),"Cannot connect to server....",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
