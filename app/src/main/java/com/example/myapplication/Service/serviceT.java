package com.example.myapplication.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author CodeMilk
 * @title: serviceT
 * @projectName My Application
 * @description: 关于Service的生命周期 相关函数
 * @date 2022/4/4 17:00
 */
public class serviceT extends Service {

    private static final String TAG = "codeMilk";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()...... ");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()...... ");
        Log.e(TAG, "调用了service");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()...... ");
/*         for (int i = 0; i < 200; i++) {
            try {
                sleep(100);
                Log.e(TAG, "后台运行中: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   */
        for (int i = 0; i < 200; i++) {
            Log.e(TAG, "后台运行中: " + i);

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()...... ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()...... ");
        Log.e(TAG, "关闭了service");
        super.onDestroy();
    }
}
