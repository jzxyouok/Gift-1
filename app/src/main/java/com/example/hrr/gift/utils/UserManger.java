package com.example.hrr.gift.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.hrr.gift.db.DBManager;
import com.example.hrr.gift.entity.User;

/**
 * Created by HRR on 2016/6/15.
 */
public class UserManger {
    SharedPreferences spf;
    SharedPreferences.Editor spfe;
    Context gC;
    DBManager dbManager;
    public UserManger(Context gC) {
        this.gC = gC;
        dbManager=new DBManager(gC);
        spf=gC.getSharedPreferences("user",Context.MODE_PRIVATE);
        spfe=gC.getSharedPreferences("user",Context.MODE_PRIVATE).edit();//实例化spfe存储
    }

    /**
     * 登陆验证方法
     */
    public boolean checklogin(String loginname,String loginpwd){
        boolean ifcheckefind=false;
        User user=dbManager.findone(loginname,loginpwd);
        if(user!=null){
            ifcheckefind=true;
            spfe.putString("username",loginname);
            spfe.putString("userpwd",loginpwd);
            spfe.commit();
        }else {
            ifcheckefind=false;
        }
        return ifcheckefind;
    }
    /**
     * 注册验证方法
     */
    public boolean checkregister(String name,String pwd){
        boolean ifregister=false;
        if(dbManager.add(name,pwd)){
            Toast.makeText(gC,"注册成功",Toast.LENGTH_SHORT).show();
            ifregister=true;
        }
        return ifregister;
    }
    public User getuser(){
        User user;
        String name=spf.getString("username",null);
        String pwd=spf.getString("userpwd",null);
        user=new User(name,pwd);
        return user;
    }
}
