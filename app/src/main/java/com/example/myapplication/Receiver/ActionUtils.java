package com.example.myapplication.Receiver;

/**
 * @author CodeMilk
 * @title: ActionUtils
 * @projectName My Application
 * @description: TODO
 * @date 2022/4/5 22:49
 */
public interface ActionUtils {
    // 广播注册时 与 发送广播时的唯一标识，必须要保持一致(给动态注册用)
    String ACTION_EQUES_UPDATE_IP = "com.android.ACTION_01";

    // 广播注册时 与 发送广播时的唯一标识，必须要保持一致(给静态注册用)
    String ACTION_FLAG = "com.android.ACTION_01";

}
