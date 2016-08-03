package com.example.hrr.gift.gift.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
public class FrombaandmoFragment extends BaseFragment {
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    @Override
    public void onClick(View v) {

    }
    public void setresource(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                siftlist.add(new Sift(R.mipmap.frombaandmo_one,"想要为爸妈尽孝心，就送这些实用好礼","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombaandmo_two,"健康生活之夏季清肺食物","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombaandmo_three,"10款国内传统糕点推荐","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombaandmo_four,"那些打着“小清新”标签的手机壳","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombaandmo_five,"多食营养坚果，还你健康身体","http://www.liwushuo.com/posts/1044007"));
                siftlist.add(new Sift(R.mipmap.frombaandmo_six,"必须让他准备充分，装备一流","http://www.liwushuo.com/posts/1044007"));
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
