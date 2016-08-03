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
public class FromcollFragment extends BaseFragment {
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
                siftlist.add(new Sift(R.mipmap.fromcoll_one,"便携电动榨汁机，走到哪榨到哪","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromcoll_two,"假装在英国！英伦风礼物大合集","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromcoll_three,"这些“梅”味道，也敲好吃的","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromcoll_four,"那些打着“小清新”标签的手机壳","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromcoll_five,"笔好看了，才能有心情写字啊","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.fromcoll_six,"给上班狗的护理神器，世界要有爱","http://www.liwushuo.com/posts/1044007"));
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
