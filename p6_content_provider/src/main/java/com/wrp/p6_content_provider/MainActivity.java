package com.wrp.p6_content_provider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Calendar c = Calendar.getInstance();

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Do something here
            }



        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

        Cursor people = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        while(people.moveToNext()) {
            int nameIndex = people.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            String name = people.getString(nameIndex);
            Log.d("CONTACTS", name);
        }
    }
}
