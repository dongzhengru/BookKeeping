package com.xh229100226.bighomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MoneyDAO {
    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    public MoneyDAO(Context context) {
        this.context = context;
    }
    public void open() throws SQLiteException {
        dbHelper = new DBHelper(context, "BigHomework.db", null, 1);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbHelper.getReadableDatabase();
        }
    }
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }
    public long addIncome(Money o) {
        ContentValues values = new ContentValues();
        values.put("id", o.income_id);
        values.put("money", o.income_money);
        values.put("date", o.income_date);
        values.put("type", o.income_type);
        values.put("note", o.income_note);
        return db.insert("income", null, values);
    }
    public ArrayList<Map<String, Object>> getAllIncome() {
        ArrayList<Map<String, Object>> listOrders = new ArrayList<Map<String, Object>>();
        Cursor cursor = db.query("income", null, null, null, null, null,null);

        int resultCounts = cursor.getCount();
        if (resultCounts == 0 ) {
            return null;
        } else {
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", cursor.getString(cursor.getColumnIndex("id")));
                map.put("money", cursor.getString(cursor.getColumnIndex("money")));
                map.put("date", cursor.getString(cursor.getColumnIndex("date")));
                map.put("type", cursor.getString(cursor.getColumnIndex("type")));
                map.put("note", cursor.getString(cursor.getColumnIndex("note")));
                listOrders.add(map);
            }
            return listOrders;
        }
    }
    public Money getOrders(String orderid) {
        Cursor cursor = db.query("income", null, "date=?", new String[]{orderid}, null, null, null);
        Money o = new Money();
        while (cursor.moveToNext()) {
            o.income_id = cursor.getString(cursor.getColumnIndex("id"));
            o.income_money = cursor.getString(cursor.getColumnIndex("money"));
            o.income_date = cursor.getString(cursor.getColumnIndex("date"));
            o.income_type = cursor.getString(cursor.getColumnIndex("type"));
            o.income_note = cursor.getString(cursor.getColumnIndex("note"));
        }
        return o;
    }
    public int deletOrders(Money o) {
        return db.delete("income", "date=?", new String[]{String.valueOf(o.income_date)});
    }
    public int updateOrders(Money o) {
        ContentValues value = new ContentValues();
        value.put("money", o.income_money);
        value.put("id", o.income_id);
        value.put("type", o.income_type);
        value.put("note", o.income_note);
        return db.update("income", value, "date=?", new String[]{String.valueOf(o.income_date)});
    }
    public long addPay(Money o) {
        ContentValues values = new ContentValues();
        values.put("id", o.out_id);
        values.put("money", o.out_money);
        values.put("date", o.out_date);
        values.put("type", o.out_type);
        values.put("note", o.out_note);
        return db.insert("out", null, values);
    }
    public ArrayList<Map<String, Object>> getAllPay() {
        ArrayList<Map<String, Object>> listOrders = new ArrayList<Map<String, Object>>();
        Cursor cursor = db.query("out", null, null, null, null, null,null);

        int resultCounts = cursor.getCount();
        if (resultCounts == 0 ) {
            return null;
        } else {
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", cursor.getString(cursor.getColumnIndex("id")));
                map.put("money", cursor.getString(cursor.getColumnIndex("money")));
                map.put("date", cursor.getString(cursor.getColumnIndex("date")));
                map.put("type", cursor.getString(cursor.getColumnIndex("type")));
                map.put("note", cursor.getString(cursor.getColumnIndex("note")));
                listOrders.add(map);
            }
            return listOrders;
        }
    }

    public Money getPay(String orderid) {
        Cursor cursor = db.query("out", null, "date=?", new String[]{orderid}, null, null, null);
        Money o = new Money();
        while (cursor.moveToNext()) {
            o.out_id = cursor.getString(cursor.getColumnIndex("id"));
            o.out_money = cursor.getString(cursor.getColumnIndex("money"));
            o.out_date = cursor.getString(cursor.getColumnIndex("date"));
            o.out_type = cursor.getString(cursor.getColumnIndex("type"));
            o.out_note = cursor.getString(cursor.getColumnIndex("note"));
        }
        return o;
    }

    public int updatePay(Money o) {
        ContentValues value = new ContentValues();
        value.put("money", o.out_money);
        value.put("date", o.out_date);
        value.put("type", o.out_type);
        value.put("note", o.out_note);
        return db.update("out", value, "date=?", new String[]{String.valueOf(o.out_date)});
    }

    public int deletPay(Money o) {
        return db.delete("out", "date=?", new String[]{String.valueOf(o.out_date)});
    }


}
