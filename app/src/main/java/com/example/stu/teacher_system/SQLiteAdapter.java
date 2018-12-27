package com.example.stu.teacher_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.util.Log;

/*public class SQLiteAdapter {
    SQLiteDatabase db=null;
    Context context=null;

    public SQLiteAdapter(Context context) {
        this.context = context;
    }
    public  void  opendb(){
        Helper helper=new Helper(context,"teacher",null,1);
        db=helper.getWritableDatabase();
    }
    public void closedb(){
        if (db.isOpen()){
            db.close();
        }
        db=null;
    }
    public boolean insert(Infor infor){
        boolean result = false;
        opendb();
        ContentValues values = new ContentValues();
        values.put("name",infor.getName());
        values.put("phone",infor.getPhone());
        values.put("sex",infor.getSex());
        values.put("tie",infor.getTie());
        values.put("class",infor.getBanji());

        Long rowid = db.insert("teacher",null,values);
        if(rowid!=-1){
            result=true;
            Toast.makeText(context,"添加成功",Toast.LENGTH_LONG).show();
            Log.i("数据库操作","添加成功");
       }else {
           Toast.makeText(context,"添加失败",Toast.LENGTH_LONG).show();
            Log.i("数据库操作失败","添加失败");
       }

        closedb();
        return false;
    }
    public int deleteByName(String name){
        int result = -1;
        opendb();
        result = db.delete("information", "name=?",new String[]{name});
        closedb();
        return result;
    }
}*/
