package com.example.myapplication.Receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Glide.MainActivity_Glide;
import com.example.myapplication.R;

public class MainActivity_Receiver extends AppCompatActivity {

    private CustomReceiver mCustomReceiver;

    private Button btn_RegReceiver, btn_UnregReceiver, btn_SendBroadcast, btn_ToGlideTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receiver);

        init();

/*        IntentFilter itFilter = new IntentFilter("com.android.ACTION_01");
        //Intent itFilter =new IntentFilter();
        //itFilter.addAction("tw.android.ACTION_01"); 同样用法

        mCustomReceiver = new CustomReceiver();
        //注册广播接收器
        registerReceiver(mCustomReceiver, itFilter);*/


    }

    public void init() {
        // HACK 增改取所需
        btn_RegReceiver = (Button) findViewById(R.id.btnRegReceiver);
        btn_UnregReceiver = (Button) findViewById(R.id.btnUnregReceiver);
        btn_SendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
        btn_ToGlideTest = findViewById(R.id.btnToGlide_test);

        btn_RegReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter itFilter = new IntentFilter(ActionUtils.ACTION_EQUES_UPDATE_IP);
                //Intent itFilter =new IntentFilter();
                //itFilter.addAction("tw.android.ACTION_01"); 一樣用法

                mCustomReceiver = new CustomReceiver();
                registerReceiver(mCustomReceiver, itFilter); //註冊廣播接收器
            }
        });
        // FIXME 此处还有大问题需解决,
        // TODO 今天太晚了先看美剧去了
        btn_UnregReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomReceiver != null) {
                    unregisterReceiver(mCustomReceiver); //撤銷廣播接收器
                }
            }
        });
        // XXX 可以继续优化
        btn_SendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ActionUtils.ACTION_EQUES_UPDATE_IP); //設定廣播識別碼
                it.putExtra("sender_name", "zhang san"); //設定廣播夾帶參數
                sendBroadcast(it); //發送廣播訊息
            }
        });

        btn_ToGlideTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity_Glide.class));
            }
        });

    }
}