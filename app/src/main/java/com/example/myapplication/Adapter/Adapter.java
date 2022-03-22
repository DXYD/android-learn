package com.example.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Bean.Goods;
import com.example.myapplication.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    private List<Goods> data;
    private Context context;

    public Adapter(List<Goods> data, Context context) {
        this.data = data;
        this.context = context;
        for (Goods goods: data){
            Log.e("是否传入数据", "Adapter: data:" + goods.getShopName() );
        }
    }

    /**
     * 获取总共数据
     *  在做setAdapter()方法时，程序会首先执行getCount()方法，
     *  当getCount()方法返回 0 时，就不会去执行getView()方法，
     *  所以在重写的时候要注意getCount()方法的return数据。
     * @return
     */
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * 获得Item
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return null;
    }

    /**
     * 获得Item的id
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }


    /**
     * 没有数据不会执行getView方法
     * 获得ListView中每一个Item条目视图
     * @param i 第i个item 第0个item 第1个item 第二个item 第3个item etc
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if ( view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        }
        TextView textView = view.findViewById(R.id.tv);
        textView.setText(data.get(i).getShopName());
        TextView textView1 = view.findViewById(R.id.tv_1);
        textView1.setText("这是一段商品的描述");
        Log.e("goods ", "onCreate: goods"+ i);
        return view;
    }
}
