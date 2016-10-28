package com.example.penny.myservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by penny on 2016/10/27.
 */
//新建了一个DownloadBinder类，并继承自Binder，模拟了一个下载进度的功能
public class MyService extends Service {
   /* @Override
    public IBinder onBind(Intent intent){
        return  null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //处理具体的逻辑
            }
        }).start();
        return super.onStartCommand(intent,flags,startId);
    }
    */
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 必需的通知内容
        builder.setContentTitle("content title")
                .setContentText("content describe")
                .setSmallIcon(R.mipmap.ic_launcher);

        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(notifyPendingIntent);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //manager.notify(1, notification);

        startForeground(1, notification);
        Log.d("MyService","onCreate executed");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}
