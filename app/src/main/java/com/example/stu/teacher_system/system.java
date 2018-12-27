package com.example.stu.teacher_system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class system extends AppCompatActivity {
EditText edtName,edtSex,edtNumber,edtTie,edtClass;
Button btnAdd,btnDisplay,btnDelete,btnModify;
ListView lvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        edtName=findViewById(R.id.edt_name);
        edtSex=findViewById(R.id.edt_sex);
        edtTie=findViewById(R.id.edt_tie);
        edtClass=findViewById(R.id.edt_class);
        edtNumber=findViewById(R.id.edt_number);

        btnAdd=findViewById(R.id.btn_add);
        btnDisplay=findViewById(R.id.btn_display);
        btnDelete=findViewById(R.id.btn_delete);
        btnModify=findViewById(R.id.btn_modify );

        lvShow=findViewById(R.id.lv_show);



    }
}
