package com.example.stu.teacher_system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class system extends AppCompatActivity {
EditText edtName,edtSex,edtNumber,edtTie,edtClass;
Button btnAdd,btnDisplay,btnDelete,btnModify;
ListView lvShow;
Infor infor=new Infor();
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

     btnAdd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String name=edtName.getText().toString().trim();
             String sex=edtSex.getText().toString().trim();
             String tie=edtTie.getText().toString().trim();
             String banji=edtClass.getText().toString().trim();
             Long number=Long.valueOf(edtNumber.getText().toString().trim());
            infor.setName(name);
            infor.setSex(sex);
            infor.setBanji(banji);
            infor.setTie(tie);
            infor.setPhone(number);
            SQLiteAdapter SQLiteadapter=new SQLiteAdapter(getApplicationContext());
            SQLiteadapter.insert(infor);
         }
     });
     btnDelete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String name = edtName.getText().toString().trim();
             SQLiteAdapter SQLiteadapter = new SQLiteAdapter(getApplicationContext());
             int num = SQLiteadapter.deleteByName(name);
             Toast.makeText(getApplicationContext(),"删除记录条数为"+String.valueOf(num),Toast.LENGTH_SHORT).show();
         }
     });

    }
}
