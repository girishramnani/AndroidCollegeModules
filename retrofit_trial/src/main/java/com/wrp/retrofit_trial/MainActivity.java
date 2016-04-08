package com.wrp.retrofit_trial;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        new AsyncTask<String,String,String>() {

            @Override
            protected String doInBackground(String... params) {
                try {
                    Retrofit builder  = new  Retrofit.Builder().baseUrl(Config.URL).addConverterFactory(GsonConverterFactory.create()).build();

                    UserService us =  builder.create(UserService.class);

                    Response<User> x = us.getUser().execute();

                    Log.i("RETRO",x.body().getName()+"");

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;

            }
        }.execute();

    }
}
