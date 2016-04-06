package com.wrp.p5_database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostCreateActivity extends AppCompatActivity implements View.OnClickListener {

    Button createPostButton ;
    DatabaseHelper DbHelper;
    EditText titleEdit;
    EditText contentEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_create);

        createPostButton = (Button) findViewById(R.id.savePostButton);
        titleEdit = (EditText) findViewById(R.id.titleEdit);
        contentEdit = (EditText) findViewById(R.id.contentEdit);
        DbHelper = DatabaseHelper.getInstance(getApplicationContext());

        createPostButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        DbHelper.addPost(titleEdit.getText().toString(),contentEdit.getText().toString());

        Toast.makeText(PostCreateActivity.this,"added a new Post",Toast.LENGTH_LONG).show();

    }
}
