package com.wrp.p9_custom_content_provider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title;
    EditText content;
    Button button;
    public static String DATABASE_INTENT = "com.wrp.p5_database.DATABASE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_create);


        title = (EditText) findViewById(R.id.titleEdit);
        content = (EditText) findViewById(R.id.contentEdit);
        button = (Button) findViewById(R.id.savePostButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DATABASE","clicked the button");
                Intent i = new Intent();
                i.setAction(DATABASE_INTENT);
                i.putExtra("TITLE", title.getText().toString());
                i.putExtra("CONTENT", content.getText().toString());

                sendBroadcast(i);

            }
        });





    }
}
