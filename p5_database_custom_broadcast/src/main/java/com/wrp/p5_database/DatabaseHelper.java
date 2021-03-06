package com.wrp.p5_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Girish on 22-03-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "posts";
    private static DatabaseHelper mInstance = null;
    private Context mCxt;

    public void addPost(String title,String content){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content",content);
        db.insertOrThrow(TABLE_NAME,null,values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void updatePost(int id,String title,String content){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("content",content);

        db.update(TABLE_NAME,contentValues,"id=?",new String[]{String.valueOf(id)});


    }

    public Cursor getPosts(){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT id as _id,title,content FROM %s",TABLE_NAME);
        return db.rawQuery(query,null);

    }

    public static DatabaseHelper getInstance(Context ctx){
        if(mInstance ==null){
            mInstance = new DatabaseHelper(ctx);
        }
        return mInstance;
    }

    private DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(String.format("create table %s (id int primary key,title varchar(100), content text)",TABLE_NAME));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("drop table %s",TABLE_NAME));
    }
}
