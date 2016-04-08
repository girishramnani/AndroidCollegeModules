package com.wrp.p7_shared_preferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText passwordEdit;
    EditText emailEdit;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
