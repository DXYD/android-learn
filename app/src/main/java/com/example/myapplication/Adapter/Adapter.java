package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Bean.Goods;
import com.example.myapplication.R;
import com.example.myapplication.alert_dialog;

import java.util.List;

public class Adapter extends BaseAdapter {

    private List<Goods> data;
    private Context context;

    /**
     * 经常在文章中看到ViewHolder来优化ListView，但其实ViewHolder不是库函数，而是需要自己定义的类。
     * （注意viewHolder里面item方法重绘：如invalidate，setVisiblity，requestLayout后，会调用adapter的getView方法）
     *
     * 使用ViewHolder的原因是findViewById方法耗时较大，如果控件个数过多，会严重影响性能，
     * 而使用ViewHolder主要是为了可以省去这个时间。通过setTag，getTag直接获取View。
     */
    class  ViewHolder{
        TextView name;
        ImageView img;
    }

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
        ViewHolder holder = new ViewHolder();

        if ( view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
            holder.name = (TextView) view.findViewById(R.id.tv);
            holder.img = (ImageView) view.findViewById(R.id.im);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //设置holder
        holder.name.setText(data.get(i).getShopName());
        holder.img.setImageResource(R.drawable.ic_launcher_foreground);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,alert_dialog.class);
                intent.putExtra("id", String.valueOf(i));
                Log.e("id : ", "onClick: " + i);
                context.startActivity(intent);
            }
        });

        Log.e("goods ", "onCreate: goods"+ i);
        return view;
    }
}
