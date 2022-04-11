package com.example.myapplication.other;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    private Fragment fragWord, fragReview, fragMe;

    private Fragment[] fragments;

    //用于记录上个选择的Fragment
    public static int lastFragment;

    private BottomNavigationView bottomNavigationView;

    private LinearLayout linearLayout;

    private static final String TAG = "MainActivity";

    public static boolean needRefresh = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        init();

        if (needRefresh) {

            TranslateAnimation animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f
            );
            animation.setDuration(2000);
            //bottomNavigationView.startAnimation(animation);
        }

        initFragment();

    }

    // 初始化控件
    private void init() {

    }

    // 初始化initFragment
    private void initFragment() {

    }

    private void switchFragment(int lastIndex, int index) {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
