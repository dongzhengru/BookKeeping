package com.xh229100226.bighomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "BigHomework.db";
    public static final int DB_VERSION = 1;
    public static final String CREATE_USERDATA2 = "create table tb_income(id interger primary key,money varchar(20),date varchar(20),type varchar(20),note varchar(20))";
    public static final String CREATE_USERDATA3 = "create table tb_out(id interger primary key,money varchar(20),date varchar(20),type varchar(20),note varchar(20))";
    public DBHelper(Context DBHelper, String s, Object o, int i) {
        super(DBHelper, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA2);
        db.execSQL(CREATE_USERDATA3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
