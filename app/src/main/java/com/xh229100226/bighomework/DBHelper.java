package com.xh229100226.bighomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String db = "BigHomework.db";
    public static final int version = 1;
    public static final String sq1 = "create table income(id interger primary key,money varchar(20),date varchar(20),type varchar(20),note varchar(20))";
    public static final String sql2 = "create table out(id interger primary key,money varchar(20),date varchar(20),type varchar(20),note varchar(20))";
    public DBHelper(Context DBHelper, String s, Object o, int i) {
        super(DBHelper, db, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sq1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
