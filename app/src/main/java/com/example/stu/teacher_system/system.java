package com.example.stu.teacher_system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class system extends AppCompatActivity {
EditText edtName,edtSex,edtNumber,edtTie,edtClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
    }
}
