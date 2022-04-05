package com.example.myapplication.Receiver;



/**
 *  Receiver两种广播
 *  系统广播与用户自定义广播
 *
 *  静态注册广播与动态注册广播
 *  BroadcastReceiver 又称作 广播接受器
 *  它是一种系统级的全范围通知，而不是针对单一位置，这样的好处是
 *  我们不必明确指出需要回应这个广播的位置，就可以驱动需要回应此广播的事件
 *
 *  例如 教务处从学校广播通知三年级二班小明今天下午三点去教务处，学校里的所有学生都会听到这一广播，
 *  但是只有小明下午三点会去教务处。
 *
 *  要使用BroadcastReceiver ，首先必须注册BroadcastReceiver 的Action，因为BroadcastReceiver 是
 *  通过Intent传送的，利用Intent中的Action属性，当作每个BroadcastReceiver 的识别码，这样外卖接收到不同的广播信息
 *  只要判断其Intent中的Action信息
 *
 *  注册广播接收器 -- registerReceiver
 *  1.通过AndroidManifest.xml文件中注册（静态注册）以及java代码中注册（动态注册）
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 静态注册
 * 只需要在清单文件里面写入如下语句
 *
 *        <receiver android:name="CustomReceiver">
 *             <intent-filter>
 *                 <action android:name="com.android.ACTION_01"/> <!--註冊 廣播接收器-->
 *             </intent-filter>
 *         </receiver>
 */

/**
 * @author CodeMilk
 * @title: CustomReceiver
 * @projectName My Application
 * @description: 以下为动态注册的接收者
 * @date 2022/4/5 22:20
 */
public class CustomReceiver extends BroadcastReceiver {

    private static final String TAG = "codeMilk";

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("sender_name");
        Log.e(TAG, "onReceive: "+ name);
    }
}
