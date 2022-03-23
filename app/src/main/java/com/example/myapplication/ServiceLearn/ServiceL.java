package com.example.myapplication.ServiceLearn;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * 服务是在后台运行的，不可见的
 * 使用startActivity 开启一个服务
 */
public class ServiceL extends Service {

    private final String TAG = "codeMilk";

    public ServiceL() {
        super();
        Log.e(TAG, "ServiceL: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}