package com.example.myapplication.Service;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * @author CodeMilk
 * @title: serviceT
 * @projectName My Application
 * @description: 介绍
 * @date 2022/4/4 18:38
 */
public class showServiceIntroduce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service_introduce);

        TextView article_text = findViewById(R.id.Service_Introduce);
        registerForContextMenu(article_text);
    }
}