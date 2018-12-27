package com.example.stu.teacher_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class system extends AppCompatActivity implements View.OnClickListener {
EditText edtName,edtSex,edtNumber,edtTie,edtClass;
Button btnAdd,btnDisplay,btnDelete,btnModify;
ListView lvShow;
Helper helper;
Infor infor=new Infor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        helper=new Helper(this);
        edtName=findViewById(R.id.edt_name);
        edtSex=findViewById(R.id.edt_sex);
        edtTie=findViewById(R.id.edt_tie);
        edtClass=findViewById(R.id.edt_class);
        edtNumber=findViewById(R.id.edt_number);

        btnAdd=findViewById(R.id.btn_add);
        btnDisplay=findViewById(R.id.btn_display);
        btnDelete=findViewById(R.id.btn_delete);
        btnModify=findViewById(R.id.btn_modify );
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);
        btnModify.setOnClickListener(this);

        lvShow=findViewById(R.id.lv_show);

     /*btnAdd.setOnClickListener(new View.OnClickListener() {
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
     });*/
     /*btnDelete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String name = edtName.getText().toString().trim();
             SQLiteAdapter SQLiteadapter = new SQLiteAdapter(getApplicationContext());
             int num = SQLiteadapter.deleteByName(name);
             Toast.makeText(getApplicationContext(),"删除记录条数为"+String.valueOf(num),Toast.LENGTH_SHORT).show();
         }
     });*/
    }

    @Override
    public void onClick(View v) {
        String name,sex,tie,banji,phone;
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()){
            case R.id.btn_add:
                name=edtName.getText().toString();
                sex=edtSex.getText().toString();
                tie=edtTie.getText().toString();
                banji=edtClass.getText().toString();
                phone=edtNumber.getText().toString();
                db=helper.getReadableDatabase();
                values=new ContentValues();
                values.put("name",name);
                values.put("sex",sex);
                values.put("tie",tie);
                values.put("banji",banji);
                values.put("phone",phone);
                 db.insert("teacher",null,values);
                 Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                 db.close();
                 break;
            case R.id.btn_delete:
                db=helper.getReadableDatabase();
                db.delete("teacher",null,null);
                Toast.makeText(this,"删除成功！",Toast.LENGTH_SHORT).show();
                db.close();
                break;
        }

    }
}
class Helper extends SQLiteOpenHelper {
  public  Helper(Context context){
      super(context,"itcast.db",null,1);
  }
   @Override
    public  void onCreate(SQLiteDatabase db){
      db.execSQL("create table teacher(_id integer primary key autoincrement,"+"name verchar(20),sex verchar(10),tie verchar(20),banji verchar(20),phone verchar(20) )");
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}