package com.wrp.p7_shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogoutActivity extends AppCompatActivity {

    Button button;
    static String FILENAME = "SHARED_PREFERENCE";
    Button saveButton;
    EditText FileEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        button = (Button) findViewById(R.id.logoutButton);
        SharedPreferences preferences = getSharedPreferences("APPLICATION", MODE_PRIVATE);

        String data = preferences.getString("login","anon");


        if(data.contentEquals("anon")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
              finish();
        }


        FileEdit = (EditText) findViewById(R.id.fileEdit);
        saveButton = (Button) findViewById(R.id.SaveButton);

        String file_data = read_data();
        FileEdit.setText(file_data);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write_data(FileEdit.getText().toString());
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor p = getSharedPreferences("APPLICATION", MODE_PRIVATE).edit();
                p.remove("login");
                p.commit();
                Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    void write_data(String data){
        try (FileOutputStream fileOutputStream = openFileOutput(FILENAME, MODE_PRIVATE);
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutputStream.getFD()))
        ){
            writer.write(data);
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String read_data(){
        try {
            FileInputStream fileInputStream = openFileInput(FILENAME);

            FileReader fileReader = new FileReader(fileInputStream.getFD());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String c;
            StringBuilder builder = new StringBuilder();
            while((c = bufferedReader.readLine()) != null){

                builder.append(c);

            }


            return builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
