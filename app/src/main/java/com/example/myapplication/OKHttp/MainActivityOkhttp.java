package com.example.myapplication.OKHttp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.MainActivity_Retrofit;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OKHttp的学习
 *
 * @author codeMilk
 * @version 1.0
 */
public class MainActivityOkhttp extends AppCompatActivity {

    private static final String TAG = "codeMilk";
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_okhttp);

        okHttpClient = new OkHttpClient();
    }


    /**
     * Btn ok http 1.
     * GET异步请求
     *
     * @param view the view
     */
    public void btn_OKHttp_1(View view) {
        Request request = new Request.Builder().url("https://httpbin.org/get?username=zhangsan&age=0").build();
        // 准备好请求的的Call对象
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.i(TAG, response.body().string());
                }
            }
        });

    }


    /**
     * Btn ok http 2.
     * POST异步请求
     *
     * @param view the view
     */
    public void btn_OKHttp_2(View view) {
        OkHttpClient client = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "admin")
                .build();

        final Request request = new Request.Builder()
                .url("https://httpbin.org/post")
                .post(formBody)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.i(TAG, response.body().string());
            }
        });
    }


    /**
     * Btn ok http 3.
     * GET同步请求
     *
     * @param view the view
     * @author codeMilk
     */
    public void btn_OKHttp_3(View view) {

        /**
         * 同步请求会等待响应之后才作出相应操作
         * 如果不加线程，可能会导致阻塞后续代码的执行
         */
        new Thread() {
            @Override
            public void run() {
                Request request = new Request.Builder().url("https://httpbin.org/get?username=zhangsan").build();
                // 准备好请求的的Call对象
                Call call = okHttpClient.newCall(request);

                try {
                    Response response = call.execute();
                    Log.i(TAG, response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    /**
     * Btn ok http 4
     * POST同步请求
     *
     * @param view the view
     */
    public void btn_OKHttp_4(View view) {
        startActivity(new Intent(this, MainActivity_Retrofit.class));
    }


    /**
     * Text int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public int text(int a, int b) {
        return a + b;
    }
}