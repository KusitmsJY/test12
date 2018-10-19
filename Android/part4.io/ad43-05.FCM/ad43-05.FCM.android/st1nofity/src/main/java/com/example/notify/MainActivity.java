package com.example.notify;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStausBar = (Button) findViewById(R.id.btnStausBar);
        btnStausBar.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                CharSequence contextTitle = "new message";
                CharSequence contextText = "welcome to an android world";
                
                Context context = getApplicationContext();
                Intent notifyIntent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, notifyIntent, 0);
                Notification noti = new Notification.Builder(context)
                                                    .setContentTitle(contextTitle)
                                                    .setContentText(contextText)
                                                    .setSmallIcon(R.drawable.wikibooks_logo_trans)
                                                    .setContentIntent(contentIntent)
                                                    //.setLargeIcon(aBitmap)
                                                    .build();
                NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1, noti);                
            }
        });
    }
}
