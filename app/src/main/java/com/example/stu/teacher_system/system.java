package com.example.stu.teacher_system;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class system extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtSex, edtNumber, edtTie, edtBanji;
    Button btnAdd, btnDisplay, btnDelete, btnModify, btncha;
   ListView lsshow;
    //TextView tvshow;
    Helper helper;
    Infor infor = new Infor();
    List<Infor>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        helper = new Helper(this);
        edtName = findViewById(R.id.edt_name);
        edtSex = findViewById(R.id.edt_sex);
        edtTie = findViewById(R.id.edt_tie);
        edtBanji = findViewById(R.id.edt_banji);
        edtNumber = findViewById(R.id.edt_number);
        //tvshow = findViewById(R.id.tv_show);
        lsshow=findViewById(R.id.ls_show);

        btnAdd = findViewById(R.id.btn_add);
        btnDisplay = findViewById(R.id.btn_display);
        btnDelete = findViewById(R.id.btn_delete);
        btnModify = findViewById(R.id.btn_modify);
        btncha = findViewById(R.id.btn_cha);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btncha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String name, sex, tie, banji, phone;
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()) {
            case R.id.btn_add:
                name = edtName.getText().toString();
                sex = edtSex.getText().toString();
                tie = edtTie.getText().toString();
                banji = edtBanji.getText().toString();
                phone = edtNumber.getText().toString();
                db = helper.getReadableDatabase();
                values = new ContentValues();
                values.put("name", name);
                values.put("sex", sex);
                values.put("tie", tie);
                values.put("banji", banji);
                values.put("phone", phone);
                if (name.equals("")) {
                    Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    db.insert("teacher", null, values);
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case R.id.btn_delete:
                db = helper.getReadableDatabase();
                db.delete("teacher", "name=?", new String[]{edtName.getText().toString()});
                Toast.makeText(this, "删除成功！", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_display:
                //tvshow.setText("");
                db = helper.getReadableDatabase();
                list = new ArrayList<Infor>();
                Cursor cursor = db.query("teacher", null, null, null, null, null, null);
                if (cursor.moveToFirst()){
                    do {

                        Infor infor = new Infor();
                        infor.setName(cursor.getString(1));
                        infor.setSex(cursor.getString(2));
                        infor.setTie(cursor.getString(3));
                        infor.setBanji(cursor.getString(4));
                        infor.setPhone(cursor.getString(5));
                        list.add(infor);
                    }while (cursor.moveToNext());
                }
                lsshow.setAdapter(new MyAdapter());
               /* if (cursor.getCount() == 0) {
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                } else {
                    cursor.moveToFirst();
                    tvshow.setText("姓名：" + cursor.getString(1) + " 性别：" + cursor.getString(2) + " 专业：" + cursor.getString(3) + "\n" + "所教班级：" + cursor.getString(4) + "  联系方式：" + cursor.getString(5));
                }
                while (cursor.moveToNext()) {
                    tvshow.append("\n" + "姓名：" + cursor.getString(1) + " 性别：" + cursor.getString(2) + " 专业：" + cursor.getString(3) + "\n" + "所教班级：" + cursor.getString(4) + "  联系方式：" + cursor.getString(5));
                }*/
                cursor.close();
                db.close();
                break;
            case R.id.btn_modify:
                db = helper.getWritableDatabase();
                values = new ContentValues();
                values.put("name", name = edtName.getText().toString());
                values.put("sex", sex = edtSex.getText().toString());
                values.put("tie", tie = edtTie.getText().toString());
                values.put("banji", banji = edtBanji.getText().toString());
                values.put("phone", phone = edtNumber.getText().toString());
                db.update("teacher", values, "name=?", new String[]{edtName.getText().toString()});
                Toast.makeText(this, "信息已修改！", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_cha:
                /*tvshow.setText("");
                db = helper.getWritableDatabase();
                String chaname=edtName.getText().toString();
                String chasex=edtSex.getText().toString();
                Cursor cursor1=db.query("teacher",null,"name=? and sex=?",new String[]{chaname,chasex},null,null,null);
                if (cursor1.getCount() == 0) {
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                } else {
                    cursor1.moveToFirst();
                    tvshow.setText("姓名：" + cursor1.getString(1) + " 性别：" + cursor1.getString(2) + " 专业：" + cursor1.getString(3) + "\n" + "所教班级：" + cursor1.getString(4) + "  联系方式：" + cursor1.getString(5));
                }*/
                     break;
        }
    }
    class  MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View view=View.inflate(system.this,R.layout.list_time,null);
                TextView tname=view.findViewById(R.id.tvname);
            TextView tsex=view.findViewById(R.id.tvsex);
            TextView ttie=view.findViewById(R.id.tvtie);
            TextView tbanji=view.findViewById(R.id.tvbanji);
            TextView tphone=view.findViewById(R.id.tvphone);
            Infor infor=(Infor)getItem(position);
            tname.setText(String.valueOf(infor.getName()));
            tsex.setText(String.valueOf(infor.getSex()));
            ttie.setText(String.valueOf(infor.getTie()));
            tbanji.setText(String.valueOf(infor.getBanji()));
            tphone.setText(String.valueOf(infor.getPhone()));
                return view;
        }
    }

}

class Helper extends SQLiteOpenHelper {
    public Helper(Context context) {
        super(context, "itcast.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teacher(_id integer primary key autoincrement," + "name verchar(20),sex verchar(10),tie verchar(20),banji verchar(20),phone verchar(20) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
