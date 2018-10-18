package com.example.yossi.foregroundservice_not;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class PushNotService extends Service {

    @Override
    public void onCreate() {



    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startForeground(1,getNotification());
        return super.onStartCommand(intent, flags, startId);


    }


    @Override
    public void onDestroy() {
        super.onDestroy();


        stopForeground(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public Notification getNotification()
    {

        //phase 1 - create intent & pendingIntent
        Intent intent = new Intent(this,Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);


        //phase 2 - builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);


        //phase 3 - Notification
        Notification notification = builder.setContentIntent(pendingIntent).
                setSmallIcon(R.drawable.ic_launcher_background). // must
                setTicker("this is the ticker...").
                setContentTitle("title"). //must
                setContentText("bla bla...").
                setWhen(System.currentTimeMillis()).
                build();


        //phase 4  - NotificationManager
        /*NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);*/

        return notification;


    }

}
