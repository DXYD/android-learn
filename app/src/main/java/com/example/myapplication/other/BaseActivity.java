package com.example.myapplication.other;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.other.config.ConfigData;
import com.example.myapplication.other.listener.PermissionListener;
import com.example.myapplication.other.util.ActivityCollector;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeMilk
 * @version 1.0
 * @title BaseActivity
 * @projectName My Application
 * @description TODO
 * @date 2022/4/11 19:17
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    private PermissionListener mListener;

    private static final int PERMISSION_REQUESTCODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());

        if (ConfigData.getIsNight()) {
            // 沉浸式状态栏，设置深色
            ImmersionBar.with(this)
                    .statusBarDarkFont(false)
                    .init();
        } else {
            ImmersionBar.with(this)
                    .statusBarDarkFont(true)
                    .init();
        }

        ActivityCollector.addActivity(this);

        // 防止输入法将布局顶上去
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    // 权限
    public void requestRunPermission(String[] permissions, PermissionListener listener) {
        mListener = listener;
        List<String> permissionLists = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionLists.add(permission);
            }
        }
        if (!permissionLists.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissionLists.toArray(new String[permissionLists.size()]), PERMISSION_REQUESTCODE);
        } else {
            //表示全都授权了
            mListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUESTCODE:
                if (grantResults.length > 0) {
                    // 存放没授权的权限
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        // 说明都授权了
                        mListener.onGranted();
                    } else {
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    public static boolean isServiceExisted(Context context, String className) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            ActivityManager.RunningServiceInfo serviceInfo = serviceList.get(i);
            ComponentName serviceName = serviceInfo.service;
            if (serviceName.getClassName().equals(className)) {
                return true;
            }
        }
        return false;
    }


    public void windowFade() {
        getWindow().setEnterTransition(new Fade().setDuration(500));
        getWindow().setExitTransition(new Fade().setDuration(500));
        getWindow().setReenterTransition(new Fade().setDuration(500));
        getWindow().setReturnTransition(new Fade().setDuration(500));
    }

    public void windowSlide(int position) {
        getWindow().setEnterTransition(new Slide(position).setDuration(300));
        getWindow().setExitTransition(new Slide(position).setDuration(300));
        getWindow().setReenterTransition(new Slide(position).setDuration(300));
        getWindow().setReturnTransition(new Slide(position).setDuration(300));
    }

    public void windowExplode() {
        getWindow().setEnterTransition(new Explode().setDuration(300));
        getWindow().setExitTransition(new Explode().setDuration(300));
        getWindow().setReenterTransition(new Explode().setDuration(300));
        getWindow().setReturnTransition(new Explode().setDuration(300));
    }


}
