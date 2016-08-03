package com.example.hrr.gift.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.activity.LoginActivity;
import com.example.hrr.gift.adapter.HomeAdapter;
import com.example.hrr.gift.base.BaseFragment;
import com.example.hrr.gift.gift.guide.FrombaandmoFragment;
import com.example.hrr.gift.gift.guide.FrombfFragment;
import com.example.hrr.gift.gift.guide.FromcollFragment;
import com.example.hrr.gift.gift.guide.FromgfFragement;
import com.example.hrr.gift.gift.guide.FromgmFragment;
import com.example.hrr.gift.gift.guide.FromjyFragment;
import com.example.hrr.gift.gift.guide.SiftFragment;
import com.example.hrr.gift.utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HRR on 2016/6/14.
 */
public class HomeFragment extends BaseFragment {
    HomeAdapter homeAdapter;
    View view,view_top;
    ViewPager viewPager;
    TabLayout tabLayout;
    List<String> namelist;
    List<Fragment> fragmentList;
    ImageView topleft;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.homefragment,null);
        return view;
    }

    @Override
    public void getview() {
        view_top=getActivity().findViewById(R.id.homefragment_top);
        namelist=new ArrayList<String>();
        fragmentList=new ArrayList<Fragment>();
        tabLayout= (TabLayout) getActivity().findViewById(R.id.home_tab_tab);
        viewPager= (ViewPager) getActivity().findViewById(R.id.home_show_vp);
        topleft= (ImageView) getActivity().findViewById(R.id.top_left_iv);
    }

    @Override
    public void setview() {
        topleft.setOnClickListener(this);
        Tools.settop(view_top,"礼尚网来",getActivity());
        setresoure();
        //设置viewpager加载几个
//        viewPager.setOffscreenPageLimit(6);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_left_iv:
                Intent i= new Intent(getActivity(),LoginActivity.class);

                startActivity(i);
                break;
        }

    }


    /**
     * 加载集合数据并将viewpager,adapter,tablayout绑定起来
     */
    public void setresoure(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                namelist.add("精选");
                namelist.add("送爸妈");
                namelist.add("送男票");
                namelist.add("送女票");
                namelist.add("送闺蜜");
                namelist.add("送基友");
                namelist.add("送同事");
                fragmentList.add(new SiftFragment());
                fragmentList.add(new FrombaandmoFragment());
                fragmentList.add(new FrombfFragment());
                fragmentList.add(new FromgfFragement());
                fragmentList.add(new FromgmFragment());
                fragmentList.add(new FromjyFragment());
                fragmentList.add(new FromcollFragment());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeAdapter=new HomeAdapter(getFragmentManager(),fragmentList,namelist);
                        viewPager.setAdapter(homeAdapter);
                        tabLayout.setTabsFromPagerAdapter(homeAdapter);
                        tabLayout.setupWithViewPager(viewPager);
                        homeAdapter.notifyDataSetChanged();
                    }
                });
            }

        }).start();

    }
}
