package com.shangeeth.gcmtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Ask Admin to Send FireBase Live Notification").setContentText(" ");
        Intent resultIntent= new Intent(this,MainActivity.class);
        TaskStackBuilder tsk=TaskStackBuilder.create(this);
        tsk.addParentStack(MainActivity.class);
        tsk.addNextIntent(resultIntent);

        PendingIntent rpi=tsk.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(rpi);

        NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1,mBuilder.build());

    }
}
