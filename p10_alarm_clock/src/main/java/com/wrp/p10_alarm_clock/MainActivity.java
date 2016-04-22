package com.wrp.p10_alarm_clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(toggleButton.isChecked()){
                 Calendar c = Calendar.getInstance();
                 c.setTimeInMillis(System.currentTimeMillis());
                 c.set(Calendar.HOUR, alarmTimePicker.getHour());
                 c.set(Calendar.MINUTE,alarmTimePicker.getMinute());

                 c.getTimeInMillis();
             }
            }
        });



    }



    public void setAlarmText(String s) {
    }


}
