package com.cpe.brutus.services;

import com.cpe.brutus.receivers.AlarmReceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

import java.util.Calendar;

public class NotificationService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;
    private Context mContext;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper, Context context) {
            super(looper);
            mContext = context;
        }

        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }

            //Toast.makeText(mContext, "Notification done !", Toast.LENGTH_SHORT).show();

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent(mContext, AlarmReceiver.class);

            Bundle data = msg.getData();
            String ts = data.getString("notifTime");
            String[] tsSeparated = ts.split(" ");
            String[] dateSeparated = tsSeparated[0].split("-");
            String[] timeSeparated = tsSeparated[1].split(":");
            int year = Integer.parseInt(dateSeparated[0]);
            int month = Integer.parseInt(dateSeparated[1]) - 1;
            int day = Integer.parseInt(dateSeparated[2]);

            int hour = Integer.parseInt(timeSeparated[0]);
            int minute = Integer.parseInt(timeSeparated[1]);
            int second = Integer.parseInt(timeSeparated[2]);

            notificationIntent.putExtra("titleText", data.getString("titleText"));
            notificationIntent.putExtra("contentText", data.getString("contentText"));

            PendingIntent broadcast = PendingIntent.getBroadcast(mContext, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, day);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.YEAR, year);

            cal.set(Calendar.HOUR_OF_DAY, hour);
            cal.set(Calendar.MINUTE, minute);
            cal.set(Calendar.SECOND, second);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        //Toast.makeText(this, "Notification service created", Toast.LENGTH_SHORT).show();
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper, this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(this, "Notification service starting", Toast.LENGTH_SHORT).show();

        Bundle data = new Bundle();
        data.putString("titleText", intent.getStringExtra("titleText"));
        data.putString("contentText", intent.getStringExtra("contentText"));
        data.putString("notifTime", intent.getStringExtra("notifTime"));

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        msg.setData(data);
        serviceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(this, "Notification service done", Toast.LENGTH_SHORT).show();
    }
}
