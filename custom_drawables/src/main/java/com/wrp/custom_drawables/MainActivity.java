package com.wrp.custom_drawables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CustomDrawable customDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        customDrawable = new CustomDrawable(getApplicationContext());
        setContentView(customDrawable);

    }
}
