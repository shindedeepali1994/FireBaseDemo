package com.deepali.firebasedemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ButterKnife.inject(this);
       // addNotification();

        Button btn;
        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o =  new Intent(MainActivity.this,MySignUp.class);
                startActivity(o);
            }
        });

    }

    private void addNotification() {

        Log.e("addNotification calles",":::");
        try {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journaldev.com/"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            builder.setContentIntent(pendingIntent);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            builder.setContentTitle("Notifications Title");
            builder.setContentText("Your notification content here.");
            builder.setSubText("Tap to view the website.");

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // Will display the notification in the notification bar
            notificationManager.notify(1, builder.build());
        }catch (Exception e){
            Log.e("Exception "," : "+e.getMessage());
        }
    }

}
