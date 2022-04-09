package com.example.myapplication.Retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Retrofit 的主使用界面
 *
 * @author codeMilk
 */
public class MainActivity_Retrofit extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpService httpService;
    private static final String TAG = "codeMilk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_retrofit);

        retrofit = new Retrofit.Builder().baseUrl("https://httpbin.org/").build();
        httpService = retrofit.create(HttpService.class);


    }

    public void btn_Retrofit_POST(View view) {
        Call<ResponseBody> call = httpService.post("codeMilk", "123456");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i(TAG, "onResponse: "+ response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
}