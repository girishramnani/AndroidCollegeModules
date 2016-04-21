package com.wrp.p5_database;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DatabaseReceiver extends BroadcastReceiver {

    public static final String CUSTOM_INTENT = "com.wrp.p5_database.DATABASE";
    public DatabaseReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(CUSTOM_INTENT)){
            Log.i("DATABASE","Got the intent");
        }
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        databaseHelper.addPost(intent.getStringExtra("TITLE"),intent.getStringExtra("CONTENT"));

    }
}
