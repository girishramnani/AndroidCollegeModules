package com.wrp.p10_alarm_clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.AlarmClock;
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
                 c.set(Calendar.HOUR, alarmTimePicker.getCurrentHour());
                 c.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());
                 Intent x = new Intent(MainActivity.this,AlarmReceiver.class);
                 pendingIntent = PendingIntent.getActivity(MainActivity.this,0,x,0);
                 alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
             }
            }
        });



    }



    public void setAlarmText(String s) {
    }


}
