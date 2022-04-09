package com.example.myapplication.Glide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

/**
 * @author codeMilk
 * @version 1.0
 */
public class MainActivity_Glide extends AppCompatActivity {

    private final String myUrl = "data:image/jpeg;base64,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";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_glide);

        ImageView imageView = findViewById(R.id.IV);
        ImageView imageView_1 = findViewById(R.id.IV_1);


        //  实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。

        RequestOptions sharedOptions =
                new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.donut_circle)
                        .fallback(R.drawable.icecream_circle)
                        .override(100, 100);

        Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .apply(sharedOptions)
                .into(imageView);

        GlideApp.with(this)
                .load(myUrl)
                .into(imageView_1);
    }

    /**
     *  Glide 与 过渡动画
     *  定义Glide如何从占位符到新加载的图片，或从缩略图到全尺寸图像过渡
     */

}