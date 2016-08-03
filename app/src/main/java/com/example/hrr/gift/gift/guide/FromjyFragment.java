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
public class FromjyFragment extends BaseFragment {
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

    }
    public void setresource(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                siftlist.add(new Sift(R.mipmap.fromjy_one,"最爱玲珑小巧的数码小物","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromjy_two,"打造日式MUJI风，一起感受霓虹国的淡雅","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromjy_three,"拥有这些，你才配叫手机狂魔","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromjy_four,"木头也可以这样玩，你学会了吗？","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromjy_five,"天生喜欢蓝——蓝色礼物大合集","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromjy_six,"对不起，我是食“肉”动物","http://www.liwushuo.com/posts/1044007"));
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
