package com.wrp.p7_shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogoutActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        button = (Button) findViewById(R.id.logoutButton);
        SharedPreferences preferences = getSharedPreferences("APPLICATION", MODE_PRIVATE);

        String data = preferences.getString("login","anon");


//        if(data.contentEquals("anon")){
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor p = getSharedPreferences("APPLICATION", MODE_PRIVATE).edit();
                p.clear();
                Intent intent = new Intent(LogoutActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


}
