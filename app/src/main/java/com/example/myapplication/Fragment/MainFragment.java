package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public class MainFragment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        Init();

    }


    void Init() {
        Button btn_fragment_1 = findViewById(R.id.btn_fragment_1);
        Button btn_fragment_2 = findViewById(R.id.btn_fragment_2);
        Button btn_fragment_3 = findViewById(R.id.btn_fragment_3);

        btn_fragment_1.setOnClickListener(this);
        btn_fragment_2.setOnClickListener(this);
        btn_fragment_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fragment_1:
                replaceFragement(new ItemFragment());
                break;
            case R.id.btn_fragment_2:
                replaceFragement(new BlankFragment());
                break;
            case R.id.btn_fragment_3:
                // send Bundle msg
                Bundle bundle = new Bundle();
                bundle.putString("message", "我喜欢你ma");
                BlankFragment blankFragment = new BlankFragment();
                blankFragment.setArguments(bundle);
//                replaceFragement(blankFragment);
                /**
                 *  BlankFragment bf = new BlankFragment();
                 */
                BlankFragment bf = new BlankFragment();
                bf.setFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainFragment.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return null;
                    }
                });
                replaceFragement(bf);
                break;
            default:
                break;
        }
    }


    // 动态切换Fragment
    private void replaceFragement(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Fragment_1, fragment);
        transaction.commit();
    }

    /**
     *  关于 activity 与 Fragment 的通信
     *  采用原生bundle来进行
     */


}