package com.wrp.p7_shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText passwordEdit;
    EditText emailEdit;
    Button loginButton;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("APPLICATION",MODE_PRIVATE);


        String data = preferences.getString("login","anon");

        if(! data.contentEquals("anon")){
            Intent intent = new Intent(this,LogoutActivity.class);
            startActivity(intent);
        }


        passwordEdit = (EditText) findViewById(R.id.PasswordEdit);
        emailEdit = (EditText) findViewById(R.id.emailEdit);
        loginButton = (Button) findViewById(R.id.SignInButton);





        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (password.contentEquals("worker")){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login",email);
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this,LogoutActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(MainActivity.this,"Sorry wrong password",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
