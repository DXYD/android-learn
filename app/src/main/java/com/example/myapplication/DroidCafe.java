package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DroidCafe extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    private ImageView IV_showDonutOrder;
    private ImageView IV_showIceCreamOrder;
    private ImageView IV_showFroyoOrder;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_cafe);
        IV_showDonutOrder = findViewById(R.id.donut);
        IV_showIceCreamOrder = findViewById(R.id.ice_cream);
        IV_showFroyoOrder = findViewById(R.id.froyo);
        showDonutOrder(IV_showDonutOrder);
        showIceCreamOrder(IV_showIceCreamOrder);
        showFroyoOrder(IV_showFroyoOrder);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void OnClick(View view, String mOrderMessage) {
        Intent intent = new Intent(DroidCafe.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }


    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(ImageView VI) {
        VI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClick(view, getString(R.string.donut_order_message));
            }
        });
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(ImageView VI) {
        VI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClick(view, getString(R.string.ice_cream_order_message));
            }
        });
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(ImageView VI) {
        VI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClick(view, getString(R.string.froyo_order_message));
            }
        });
    }

}