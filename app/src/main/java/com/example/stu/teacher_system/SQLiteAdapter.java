package com.example.stu.teacher_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteAdapter {
    SQLiteDatabase db=null;
    Context context=null;

    public SQLiteAdapter(Context context) {
        this.context = context;
    }
    public  void  Opendb(){
        Helper helper=new Helper(context,"teacher",null,1);
        db=helper.getWritableDatabase();
    }

}
