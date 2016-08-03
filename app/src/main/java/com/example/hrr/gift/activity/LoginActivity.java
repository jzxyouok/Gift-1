package com.example.hrr.gift.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseActivity;
import com.example.hrr.gift.gift.HomeActivity;
import com.example.hrr.gift.utils.UserManger;

/**
 * Created by HRR on 2016/6/13.
 */
public class LoginActivity extends BaseActivity {
    ImageView close_iv;
    Button login_bt,register_bt;
    EditText username_et,userpwd_et;
    UserManger userManger;
    @Override
    public void setlayout() {
        setContentView(R.layout.loginandregister);
    }

    @Override
    public void getview() {
        userManger=new UserManger(this);
        close_iv= (ImageView) findViewById(R.id.login_close_iv);
        login_bt= (Button) findViewById(R.id.login_login_bt);
        register_bt= (Button) findViewById(R.id.login_register_bt);
        username_et= (EditText) findViewById(R.id.login_username_et);
        userpwd_et= (EditText) findViewById(R.id.login_userpwd_et);
    }

    @Override
    public void setview() {
        close_iv.setOnClickListener(this);
        login_bt.setOnClickListener(this);
        register_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_close_iv:
                finish();
                break;
            case R.id.login_register_bt:
                checkregister();
                break;
            case R.id.login_login_bt:
                String loginname=username_et.getText().toString();
                String loginpwd=userpwd_et.getText().toString();
                Intent i;
                if (userManger.checklogin(loginname,loginpwd)){
                     i= new Intent(LoginActivity.this,HomeActivity.class);
                }else {
                    Toast.makeText(this,"您还没有注册",Toast.LENGTH_SHORT).show();
                    i= new Intent(LoginActivity.this,RegisterActivity.class);
                }
                startActivity(i);
                break;
        }
    }



    /**
     * 注册跳转方法
     */
    public void checkregister(){
      Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
}
