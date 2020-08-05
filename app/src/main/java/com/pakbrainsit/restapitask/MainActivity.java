package com.pakbrainsit.restapitask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ListView usersListview;
    private Retrofit retrofitclient;
    private ArrayList usersList;
    private List<User> templist;
    private ArrayAdapter arrayAdapter;
    private ProgressDialog progressDialog;

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
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuHome:
                return true;
            case R.id.menuSignUp:
                Intent intent1 = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent1);
                return  true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersListview = (ListView) findViewById(R.id.userslistview);
        usersList = new ArrayList<>();
        templist = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading......");
        progressDialog.show();
        retrofitclient = new RetrofitClient().getRetrofitClient(BASE_URL);
        RetrofitApi retrofitApi = retrofitclient.create(RetrofitApi.class);
        Call<List<User>> usercall = retrofitApi.getALLUsers();
        usercall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response)
            {

                templist = response.body();
                //Toast.makeText(getApplicationContext(),"Information Loaded Size Name" + response.body().size(),Toast.LENGTH_LONG).show();

                for (int i = 0;i<templist.size();i++)
                {
                    User user = response.body().get(i);
                    // Toast.makeText(getApplicationContext(),"Inside lllop",Toast.LENGTH_LONG).show();
                    usersList.add(user.getName() +"\n"+user.getUsername() +"\n"+ user.getEmail() +"\n"+ user.getPhone() +"\n"+ user.getAddress().getCity() +" \n"+ user.getAddress().getGeoLocation().getLatitude() +"\n"+ user.getAddress().getGeoLocation().getLongitude());
                }
                arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,usersList);
                usersListview.setAdapter(arrayAdapter);
                progressDialog.dismiss();
                // Toast.makeText(getApplicationContext(),"Information Loaded Size Name" + templist.size(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                t.printStackTrace();
                Toast.makeText(getApplicationContext()," On Failure",Toast.LENGTH_LONG).show();
            }
        });

    }
}
