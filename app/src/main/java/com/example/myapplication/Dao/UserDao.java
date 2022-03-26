package com.example.myapplication.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Bean.User;
import com.example.myapplication.SqliteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codemilk
 */
public class UserDao {
    private Context context;
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;

    // 构造函数
    public UserDao(Context context) {
        this.context = context;
    }

    //打开数据库
    public void open() throws SQLiteException {
        dbHelper = SqliteOpenHelper.getInstance(context);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbHelper.getReadableDatabase();
        }
    }

    //关闭数据库
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }


    /**
     * 添加User信息
     */
    public long addUser(User user){

        if (db == null){
            open();
        }

        // 创建ContentValues对象
        ContentValues values = new ContentValues();

        values.put("username", user.getUsernmae());
        values.put("age", user.getAge());
        values.put("password", user.getPassword());

        return db.insert("t_User", null, values);
    }


    //查找所有用户信息
    public ArrayList<Map<String, Object>> getUsers() {
        if (db == null){
            open();
        }

        ArrayList<Map<String, Object>> listBooks = new ArrayList<Map<String, Object>>();
        Cursor cursor = db.query("tb_Books", null, null, null, null, null,null);

        int resultCounts = cursor.getCount();  //记录数
        if (resultCounts == 0 ) {
            return null;
        } else {
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("_id", cursor.getString(0));
                map.put("username", cursor.getString(1));
                map.put("age", cursor.getString(2));
                map.put("password", cursor.getString(3));
                listBooks.add(map);
            }
            return listBooks;
        }
    }


}
