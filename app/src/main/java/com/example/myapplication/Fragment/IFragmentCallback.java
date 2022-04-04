package com.example.myapplication.Fragment;

/**
 * @author CodeMilk
 * @title: IFragmentCallback
 * @projectName My Application
 * @description: TODO
 * @date 2022/4/3 23:03
 */
public interface IFragmentCallback {
    /**
     * Fragment发送消息到Activity
     * @param msg
     */
    void sendMsgToActivity(String msg);

    /**
     * Fragment从Activity获得消息
     * @param msg
     * @return
     */
    String getMsgFromActivity(String msg);
}
