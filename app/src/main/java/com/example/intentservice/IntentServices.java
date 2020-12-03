package com.example.intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.intentservice.App.CHANNEL_ID;

public class IntentServices extends IntentService {
    public static final String TAG = "IntentService";
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();

        Notification notif = new NotificationCompat.Builder(this , CHANNEL_ID)
                .setContentText("Application's Service Starts Running ...")
                .setContentTitle("IntentService")
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .build();

        startForeground(1 , notif);
    }

    public IntentServices() {
        super("IntentServices");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "On onHandlerIntent");

        String input = intent.getStringExtra("body");

        for (int i = 0; i < 5 ; i++) {
            Log.d(TAG, input + " - " + i);
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
