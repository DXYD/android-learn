package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button bt_Login;
    private TextView tv_Register;
    private EditText et_Username,et_Pwd;
    private CheckBox save_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_Login = (Button)findViewById(R.id.loginBtn);
        et_Username = findViewById(R.id.username);
        et_Pwd = findViewById(R.id.pwd);

        bt_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_Username.getText().toString();
                String password = et_Pwd.getText().toString();
                System.out.println(username);

                if ("xiaochen".equals(username) && "123".equals(password)) {
                    Intent intent = null;

                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "click !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"username :"+username+"password :"+password,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}