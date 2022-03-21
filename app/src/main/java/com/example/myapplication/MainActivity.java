package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author codemilk
 */
public class MainActivity extends AppCompatActivity {

    private int Count = 0;
    private TextView ShowCount;
    private Button btu_countOnclick;
    private TextView textView;
    private Button btn_toBuyOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowCount = findViewById(R.id.show_count);
        btu_countOnclick = findViewById(R.id.button_count);
        btn_toBuyOrder = findViewById(R.id.btn_toBuyOrder);

        textView = findViewById(R.id.text_uri_message);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            String uri_string = "URI: " + uri.toString();
            displayMsg(uri_string);
            textView.setText(uri_string);
        }

        btn_toBuyOrder(btn_toBuyOrder);
    }


    public void btn_toBuyOrder(Button btn_toBuyOrder){
        btn_toBuyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DroidCafe.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 点击事件的handle
     *
     * @param view View是Android中所有控件的基类
     */
    public void btn1_onClick(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 统计点击次数handle
     *
     * @param view View是Android中所有控件的基类
     */
    public void countOnclick(View view) {
        int forbid = 20;
        Count++;
        if (ShowCount != null) {
            ShowCount.setText(Integer.toString(Count));
            if (Count == forbid) {
                ShowCount.setTextSize(30);
                ShowCount.setText(R.string.boring);
                Toast.makeText(this, " 不能继续点击了", Toast.LENGTH_LONG).show();
                // TODO 对于如何重启点击事件 不是特别清楚
                view.setOnClickListener(null);
            }
        }
    }

    public void btn2_Clear_countOnClick(View view) {
        Count = 0;
        ShowCount.setText(Integer.toString(Count));
        ShowCount.setTextSize(250);
        btu_countOnclick.setOnClickListener(this::countOnclick);
    }

    public void displayMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}