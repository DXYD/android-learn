package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class openWebsiteTest extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocation_edittext;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_website_test);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocation_edittext = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);

    }

    /**
     * 用Android应用默认的浏览器来打开网页
     * @param view View是Android中所有控件的基类
     */
    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        displayMsg(url);
        Log.d("网页", url);

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    /**
     * 用来分享到其他地方
     * description : users to share items in your app with social networks and other apps
     * @param view View是Android中所有控件的基类
     */
    public void shareText(View view) {
        String message = mShareTextEditText.getText().toString();
        displayMsg(message);

        // Define the mime type of the text to share
        // 定义消息的mime类型，以此让其他应用识别
        String mimeType = "txt/plain";

        // startChooser() : Show the system app chooser and send the Intent.
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle(R.string.share_txt).setText("嘻嘻").startChooser();

    }

    /**
     * 在地图上找到loc
     * @param view View是Android中所有控件的基类
     */
    // TODO 找到自己所在地区的经纬度
    public void openLocation(View view) {
        String loc = mLocation_edittext.getText().toString();
        displayMsg(loc);
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager())!= null ){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents", "Can't handle this intent");
        }
    }

    /**
     * 封装Toast的调试函数
     * @param msg 传递的String类型的消息
     */
    public void displayMsg(String msg) {
        Toast.makeText(this, "展示displayMsg: " + msg, Toast.LENGTH_SHORT).show();
    }
}