package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

/**
 * SQLiteOpenHelper 工具类 单例模式
 * 1.构造函数私有化 2.对外提供函数
 */

public class SqliteOpenHelper extends SQLiteOpenHelper {

    private static SQLiteOpenHelper mInstance;

    //1. 构造函数私有化
    public SqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //2.对外提供函数
    public static synchronized SQLiteOpenHelper getInstance(Context context){
        if ( mInstance == null ){
            // 以后想进行数据库升级，将version改称成2、3、4、5等
            mInstance = new SqliteOpenHelper(context,"sqlite.db", null, 1);
        }
        return mInstance;
    }

    /**
     * 数据库第一次创建时调用，此函数执行一次
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }


    // 数据库升级用的
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}