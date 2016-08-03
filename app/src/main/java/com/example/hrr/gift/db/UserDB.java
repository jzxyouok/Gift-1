package com.example.hrr.gift.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HRR on 2016/6/14.
 */

/**
 * 用户数据库创建类
 */
public class UserDB extends SQLiteOpenHelper {
    public UserDB(Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id integer primary key autoincrement" +
                ",name text" +
                ",pwd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
