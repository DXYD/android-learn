package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.VPAdapter;

import java.util.ArrayList;
import java.util.List;

public class view_pager extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Init();

        render();

    }

    /**
     * 初始化
     */
    private void Init(){
        viewPager = findViewById(R.id.vp);

    }

    /**
     * 渲染
     */
    private void render(){
        // 渲染
        LayoutInflater lf = LayoutInflater.from(this);
        View view1 = lf.inflate(R.layout.layout1, null);
        View view2 = lf.inflate(R.layout.layout2, null);
        View view3 = lf.inflate(R.layout.layout3, null);

        List<View> viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        ViewPager viewPager = findViewById(R.id.vp);
        VPAdapter vpAdapter = new VPAdapter(viewList);
        viewPager.setAdapter(vpAdapter);

    }

}