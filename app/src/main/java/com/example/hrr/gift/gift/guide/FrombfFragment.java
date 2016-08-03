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
public class FrombfFragment extends BaseFragment {
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
                siftlist.add(new Sift(R.mipmap.frombf_one,"便携电动榨汁机，走到哪榨到哪","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombf_two,"打造日式MUJI风，一起感受霓虹国的淡雅","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombf_three,"用这些音箱，耳朵都要怀孕了","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombf_four,"那些打着“小清新”标签的手机壳","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombf_five,"多食营养坚果，还你健康身体","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombf_six,"必须让他准备充分，装备一流","http://www.liwushuo.com/posts/1044007"));
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
