package com.example.myapplication.Service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * @author CodeMilk
 * @title: serviceT
 * @projectName My Application
 * @description: 用来测试service的Activity
 * @date 2022/4/4 17:00
 */
public class ServiceMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_service_1;
    private Button btn_service_2;
    private Button btn_service_3;
    private Button btn_service_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        init();
    }

    public void init() {
        btn_service_1 = findViewById(R.id.btn_service_1);
        btn_service_2 = findViewById(R.id.btn_service_2);
        btn_service_3 = findViewById(R.id.btn_service_3);
        btn_service_4 = findViewById(R.id.btn_service_4);

        btn_service_1.setOnClickListener(this);
        btn_service_2.setOnClickListener(this);
        btn_service_3.setOnClickListener(this);
        btn_service_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_service_1:
                display("开启service");
                startService(btn_service_1);
                break;
            case R.id.btn_service_2:
                display("关闭service");
                stopService(btn_service_2);
                break;
            case R.id.btn_service_3:
                display("点击了btn_service3");
                startActivity(new Intent(this,showServiceIntroduce.class));
                break;
            case R.id.btn_service_4:
                display("点击了btn_service4");
            default:
                break;
        }
    }

    public void display(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 启动service有两种方法：
     * 1、 Context.startService()
     * 调用者与服务之间没有关联，即使调用者退出，服务仍可运行
     * 2、 Context.bindService()
     * 调用者与服务绑定在一起，调用者一旦退出，服务也就终止
     */

    /**
     * Method to start the service
     * @param view
     */
    public void startService(View view) {
        startService(new Intent(this,serviceT.class));
    }

    /**
     * Method to stop the service
     * @param view
     */
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), serviceT.class));
    }
}