package com.example.hrr.gift.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseActivity;
import com.example.hrr.gift.utils.UserManger;

/**
 * Created by HRR on 2016/6/14.
 */
public class RegisterActivity extends BaseActivity {
    EditText username_et,userpwd_et;
    Button login_bt,register_bt;
    UserManger userManger;
    @Override
    public void setlayout() {
        setContentView(R.layout.loginandregister);
    }

    @Override
    public void getview() {
        userManger=new UserManger(this);
        login_bt= (Button) findViewById(R.id.login_login_bt);
        register_bt= (Button) findViewById(R.id.login_register_bt);
        username_et= (EditText) findViewById(R.id.login_username_et);
        userpwd_et= (EditText) findViewById(R.id.login_userpwd_et);
    }

    @Override
    public void setview() {
        login_bt.setVisibility(View.GONE);
        register_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_register_bt:
                String name=username_et.getText().toString();
                String pwd=userpwd_et.getText().toString();
               if( userManger.checkregister(name,pwd)){
                   Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                   startActivity(i);
               }
                break;
        }
    }
}
