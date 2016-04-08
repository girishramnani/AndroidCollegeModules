package com.wrp.p10_alarm_clock;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by Girish on 08-04-2016.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {



        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context,alarmUri);
        ringtone.play();

        Intent x = new Intent(context,AlarmService.class);
        startWakefulService(context,x);
        setResultCode(Activity.RESULT_OK);

    }
}
