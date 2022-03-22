package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Adapter.Adapter;
import com.example.myapplication.Bean.Goods;

import java.util.ArrayList;
import java.util.List;

public class list_view extends AppCompatActivity {

    private List<Goods> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        for (int i = 0; i < 100; i++) {
            Goods goods = new Goods();
            goods.setShopName("商品" + i);
            data.add(goods);
            Log.e("goods ", "onCreate: goods"+ goods.getShopName());
        }
        ListView listView = findViewById(R.id.lv);

        listView.setAdapter(new Adapter(data,this));

    }
}