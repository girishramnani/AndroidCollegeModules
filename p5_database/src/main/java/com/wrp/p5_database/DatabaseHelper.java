package com.wrp.p5_database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Girish on 18-03-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(){
        super();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
