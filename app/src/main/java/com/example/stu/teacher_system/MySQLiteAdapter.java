package com.example.stu.teacher_system;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteAdapter  {
    SQLiteDatabase db = null;
    Context context = null;
    public MySQLiteAdapter(Context context) {
        this.context=context;
    }
    public void opendb() {
        MyHelper helper = new MyHelper(context,"teacher",null,1);
        db = helper.getWritableDatabase();
    }

    public void closedb() {
        if (db.isOpen()) {
            db.close();
        }
        db = null;
    }


    public List<Infor> queryAll() {
        List<Infor> list = new ArrayList<>();
        opendb();
        Cursor cursor = db.query("teacher", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {


                String name = cursor.getString(cursor.getColumnIndex("name"));
                String sex = cursor.getString(cursor.getColumnIndex("sex"));
                String tie = cursor.getString(cursor.getColumnIndex("tie"));
                String banji = cursor.getString(cursor.getColumnIndex("banji"));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                Infor infor = new Infor();
                infor.setName(name);
                infor.setSex(sex);
                infor.setTie(tie);
                infor.setBanji(banji);
                infor.setPhone(phone);
            } while (cursor.moveToNext());
        }
        closedb();
        return  list;
    }

}
