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

    private final String TABLE_NAME = "t_User";
    private final String CREATE_DATABASE = "create table t_User (_id integer primary key,age varchar(20),username varchar(20),password varchar(20))";

    /**
     * DB_VERSION 用来更新数据库版本
     */
    public static final int DB_VERSION = 1;



    //1. 构造函数私有化
    public SqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //2.对外提供函数
    public static synchronized SQLiteOpenHelper getInstance(Context context){
        if ( mInstance == null ){
            // 以后想进行数据库升级，将version改称成2、3、4、5等
            mInstance = new SqliteOpenHelper(context, "sqlite.db", null, DB_VERSION);
        }
        return mInstance;
    }

    /**
     * 数据库第一次创建时调用，此函数执行一次
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
        sqLiteDatabase.execSQL("insert into "+TABLE_NAME+"(_id, age, username, password) values('00001', '男', '软件工程', '123456')");
    }


    // 数据库升级用的
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}