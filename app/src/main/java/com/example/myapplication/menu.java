package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class menu extends AppCompatActivity {

    public final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private String mOrderMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView textView = (TextView) findViewById(R.id.textView);
        setSupportActionBar(myToolbar);
        //把布局中的Toolbar当作ActionBar

        //设置图标
        myToolbar.setLogo(R.mipmap.ic_launcher);
        //设置标题
        getSupportActionBar().setTitle("CodeMilks");
        //设置副标题
        myToolbar.setSubtitle("2022.03.20");
        //设置返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置监听
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menu.this, "你点击了返回按钮", Toast.LENGTH_SHORT).show();

            }
        });
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorite:
                        Toast.makeText(menu.this, R.string.action_favorite, Toast.LENGTH_SHORT).show();
                        textView.setText(R.string.action_favorite);
                        break;
                    case R.id.action_contact_message:
                        Toast.makeText(menu.this, R.string.action_contact_message, Toast.LENGTH_SHORT).show();
                        textView.setText(R.string.action_contact_message);
                        break;
                    case R.id.action_order_message:
                        Toast.makeText(menu.this, R.string.action_order_message, Toast.LENGTH_SHORT).show();
                        textView.setText(R.string.action_order_message);
                        break;
                    case R.id.action_status_message:
                        Toast.makeText(menu.this, R.string.action_status_message, Toast.LENGTH_SHORT).show();
                        textView.setText(R.string.action_status_message);
                        break;
                    case R.id.action_favorites_message:
                        Toast.makeText(menu.this, R.string.action_favorites_message, Toast.LENGTH_SHORT).show();
                        textView.setText(R.string.action_favorites_message);
                        break;
                    case R.id.action_order:
                        Intent intent = new Intent(menu.this, OrderActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                        startActivity(intent);
                        return true;
                    case R.id.GoToContextMenu:
                        Intent intent1 = new Intent(menu.this, contextmenu.class);
                        startActivity(intent1);
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}