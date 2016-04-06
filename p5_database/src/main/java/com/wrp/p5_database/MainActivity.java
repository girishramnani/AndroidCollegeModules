package com.wrp.p5_database;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button createPostButton ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPostButton = (Button) findViewById(R.id.AddPostButton);
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PostCreateActivity.class);
                startActivity(intent);
            }
        });
        DatabaseHelper DbHelper = new DatabaseHelper(getApplicationContext());
        Cursor postCursor = DbHelper.getPosts();
       DatabaseListAdapter dp = new DatabaseListAdapter(getApplicationContext(),postCursor,true);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(dp);

}
















}
