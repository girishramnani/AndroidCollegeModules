package com.wrp.p10_alarm_clock;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Girish on 08-04-2016.
 */
public class AlarmService extends IntentService {

    
    NotificationManager alarmNotificationManager;
    public AlarmService() {
        super("alarmService");
    }
    
    
    private void sendNotification(String msg){

         alarmNotificationManager  = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);

        NotificationCompat.Builder alaBuilder = new NotificationCompat.Builder(this).setContentText("Alarm")
                .setSmallIcon(android.R.drawable.btn_radio).setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);

        alaBuilder.setContentIntent(contentIntent);

        alarmNotificationManager.notify(1,alaBuilder.build());


        
        
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        
    }
}

