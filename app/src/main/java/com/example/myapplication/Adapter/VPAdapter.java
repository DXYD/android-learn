package com.example.myapplication.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @author CodeMilk
 * @title: VP2Adapter
 * @projectName My Application
 * @description: TODO
 * @date 2022/3/27 10:07
 */
public class VPAdapter extends PagerAdapter {

    private List<View> mListView;

    public VPAdapter(List<View> mListView) {
        this.mListView = mListView;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mListView.get(position));
        return mListView.get(position);
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mListView.get(position));
    }
}
