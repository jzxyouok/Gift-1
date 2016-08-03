package com.example.hrr.gift.gift;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.gift.guide.CategoryFragment;
import com.example.hrr.gift.activity.fragment.HomeFragment;
import com.example.hrr.gift.gift.aboutme.MeFragment;
import com.example.hrr.gift.activity.fragment.SelectFragment;
import com.example.hrr.gift.entity.ButtomChange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HRR on 2016/6/13.
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    View view;
    LayoutInflater layoutInflater;
    ImageView home_iv,select_iv,category_iv,profile_iv;
    TextView home_tv,select_tv,category_tv,profile_tv;
    List<ButtomChange> changeList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }
    @Override
    protected void onStart() {
        super.onStart();
        getview();
        setview();
    }
    public void getview() {
        view=findViewById(R.id.homefragment_top);
        home_iv= (ImageView) findViewById(R.id.home_buttom_home_tb);
        select_iv= (ImageView) findViewById(R.id.home_buttom_select_tb);
        category_iv= (ImageView) findViewById(R.id.home_buttom_category_tb);
        profile_iv= (ImageView) findViewById(R.id.home_buttom_profile_tb);
        home_tv= (TextView) findViewById(R.id.home_buttom_home_tv);
        select_tv= (TextView) findViewById(R.id.home_buttom_home_tv);
        category_tv= (TextView) findViewById(R.id.home_buttom_home_tv);
        profile_tv= (TextView) findViewById(R.id.home_buttom_home_tv);
        changeList=new ArrayList<ButtomChange>();
        layoutInflater=getLayoutInflater().from(this);

    }

    public void setview() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.home_top_rl,new HomeFragment());
        ft.commit();
        addlistresourse();
        for (int i=0;i<changeList.size();i++){//设置底部监听
            changeList.get(i).getImg().setOnClickListener(this);
        }

    }
    public void onClick(View v) {
        for (int i=0;i<changeList.size();i++){
            ButtomChange change=changeList.get(i);
            if(v.getId()==change.getImg().getId()){
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                changeList.get(i).getImg().setImageResource(change.getAfter());
                ft.replace(R.id.home_top_rl,change.getChange());
                ft.commit();
            }else{
                changeList.get(i).getImg().setImageResource(change.getBefore());
            }
        }
    }


    public void addlistresourse(){
        changeList.add(new ButtomChange(home_iv,R.mipmap.ic_tab_home_normal,R.mipmap.ic_tab_home_selected,new HomeFragment()));
        changeList.add(new ButtomChange(select_iv,R.mipmap.ic_tab_select_normal,R.mipmap.ic_tab_select_selected,new SelectFragment()));
        changeList.add(new ButtomChange(category_iv,R.mipmap.ic_tab_category_normal,R.mipmap.ic_tab_category_selected,new CategoryFragment()));
        changeList.add(new ButtomChange(profile_iv,R.mipmap.ic_tab_profile_normal,R.mipmap.ic_tab_profile_selected,new MeFragment()));
    }
}
