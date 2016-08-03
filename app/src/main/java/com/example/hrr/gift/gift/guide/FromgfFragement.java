package com.example.hrr.gift.gift.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.adapter.SiftAdapter;
import com.example.hrr.gift.base.BaseFragment;
import com.example.hrr.gift.entity.Sift;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HRR on 2016/6/13.
 */
public class FromgfFragement extends BaseFragment {
    View view;
    ListView listView;
    SiftAdapter siftAdapter;
    List<Sift> siftlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.sift,null);
        return view;
    }
    @Override
    public void getview() {
        listView= (ListView) view.findViewById(R.id.sift_listviwe_lv);
        siftlist=new ArrayList<Sift>();
    }

    @Override
    public void setview() {
        setresource();

    }
    @Override
    public void onClick(View v) {

    }public void setresource(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                siftlist.add(new Sift(R.mipmap.formgf_one,"拜托了冰箱：一打开满满都是吃的，好心情爆表","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.formgf_two,"谈过色系数码小标配，来也~","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.formgf_three,"美貌耳夹在手，不打耳洞又何妨","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.formgf_four,"夏日姨妈期，吃这些让你告别疼痛两双升级~","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.formgf_five,"投其所好！送文艺女最爱的生日礼物","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.formgf_six,"关爱女生“成长”计划，美丽永恒健康相伴","http://www.liwushuo.com/posts/1044007"));
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        siftAdapter=new SiftAdapter(siftlist,getActivity());
                        listView.setAdapter(siftAdapter);
                        siftAdapter.notifyDataSetChanged();

                    }
                });
            }
        }).start();
    }

}
