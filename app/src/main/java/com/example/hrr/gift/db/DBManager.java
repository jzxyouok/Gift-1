package com.example.hrr.gift.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.hrr.gift.entity.User;

/**
 * Created by HRR on 2016/6/14.
 */
public class DBManager {
    Context gC;
    SQLiteDatabase userdata;
    /**
     * 构造方法，建立数据库，初始化SQLiteDatabase
     * @param gC
     */
    public DBManager(Context gC) {
        this.gC = gC;
        UserDB userDB=new UserDB(gC);
        if (userDB!=null){
            userdata=userDB.getReadableDatabase();
        }
    }

    /**
     * 查询方法
     * @param name
     * @param pwd
     * @return
     */
    public User findone(String name,String pwd){
        User user=null;
        Cursor cursor;
        cursor=userdata.rawQuery("select * from user",null);//将use取出
        if (cursor!=null){
            while (cursor.moveToNext()){
                String findname=cursor.getString(cursor.getColumnIndex("name"));
                String findpwd=cursor.getString(cursor.getColumnIndex("pwd"));
                if(name.equals(findname)&&pwd.equals(findpwd)){//查找数据库中是否存在该用户名和密码
                    user=new User(findname,findpwd);
                    break;
                }
            }
        }
        return user;
    }

    /**
     * 添加方法
     * @param name
     * @param pwd
     * @return
     */
    public boolean add(String name,String pwd){
        boolean ifadd =false;
        ContentValues cv=new ContentValues();
        User user=findone(name,pwd);//获取输入的用户名和密码
        String addname;
        if (user==null){//判断数据库中是否存在该用户
            cv.put("name",name);
            cv.put("pwd",pwd);
            userdata.insert("user",null,cv);//向数据库中添加该条数据
            ifadd=true;//添加成功返回true
        }else{
            Cursor cursor=userdata.rawQuery("select * from user",null);//取出数据库中的用户
            if (cursor!=null){
                while (cursor.moveToNext()){
                    addname=cursor.getString(cursor.getColumnIndex("name"));//取出用户名
                    if(name.equals(addname)){//判断该用户名是否存在
                        Toast.makeText(gC,"该用户已被注册",Toast.LENGTH_SHORT).show();
                        ifadd=false;//用户名存在返回false
                        break;
                    }else{
                        cv.put("name",name);
                        cv.put("pwd",pwd);
                        userdata.insert("user",null,cv);//向数据库中添加该条数据
                        ifadd=true;//添加成功返回true
                        break;
                    }
                }
            }
        }
        return ifadd;
    }
}
