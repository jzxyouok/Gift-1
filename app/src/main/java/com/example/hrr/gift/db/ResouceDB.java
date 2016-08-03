package com.example.hrr.gift.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HRR on 2016/6/14.
 */

/**
 * 资源数据库创建类
 */
public class ResouceDB extends SQLiteOpenHelper {
    public ResouceDB(Context context) {
        super(context, "resouce.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sift(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table frombaandmo(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table frombf(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table fromgf(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table fromgm(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table fromjy(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
        db.execSQL("create table fromcoll(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
