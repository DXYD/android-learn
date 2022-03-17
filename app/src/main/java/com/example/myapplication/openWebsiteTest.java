package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class openWebsiteTest extends AppCompatActivity {

    private EditText mWebsiteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_website_test);
        mWebsiteEditText = findViewById(R.id.website_edittext);
    }

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

    public void shareText(View view) {

    }

    public void openLocation(View view) {

    }


    public void displayMsg(String msg){
        Toast.makeText(this, "展示displayMsg: "+ msg, Toast.LENGTH_SHORT).show();
    }
}