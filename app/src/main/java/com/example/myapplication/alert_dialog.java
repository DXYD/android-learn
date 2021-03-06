package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Bean.User;
import com.example.myapplication.Dao.UserDao;

public class alert_dialog extends AppCompatActivity {

    private String str;
    private static final String TAG = "codeMilk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        Intent intent = getIntent();
        str = intent.getStringExtra("id");
    }

    public void btn_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher_foreground).setTitle("我是对话框").setMessage(str + " 今天天气怎么样啊")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "点击了确定");
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e(TAG, "点击了取消");
            }
        }).setNeutralButton("中间", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e(TAG, "onClick: 点击了中间");
            }
        }).create().show();
    }

    public void btn_delete_data(View view) {

    }

    public void btn_insert_Data(View view) {
        UserDao userDao = new UserDao(this);
        userDao.open();
        userDao.addUser(new User("李四","男","123456"));

/*        ArrayList list = userDao.getUsers();

        for (Object user: list) {
            Log.e(TAG, "btn_insert_Data: "+ user);
        }*/
    }
}