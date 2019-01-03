package com.example.stu.teacher_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
   EditText  name,passwork;
   Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.et_login_name);
        passwork=findViewById(R.id.et_login_passwork);
        login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwork.getText().toString().equals("12345678")) {
                    Intent intent = new Intent(com.example.stu.teacher_system.login.this, system.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(login.this, "用户名或密码不正确！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
