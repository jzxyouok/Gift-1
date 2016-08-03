package com.example.hrr.gift.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.entity.Sift;

import java.util.List;

/**
 * Created by HRR on 2016/6/13.
 */
public class SiftAdapter extends BaseAdapter {
    List<Sift> siftList;
    Context gC;

    public SiftAdapter(List<Sift> siftList, Context gC) {
        this.siftList = siftList;
        this.gC = gC;
    }

    public List<Sift> getSiftList() {
        return siftList;
    }

    public void setSiftList(List<Sift> siftList) {
        this.siftList = siftList;
    }

    public Context getgC() {
        return gC;
    }

    public void setgC(Context gC) {
        this.gC = gC;
    }

    @Override
    public int getCount() {
        return siftList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(gC).inflate(R.layout.viewpager_next,null);
            viewHolder=new ViewHolder();
            viewHolder.img= (ImageView) convertView.findViewById(R.id.viewpager_next_iv);
            viewHolder.content= (TextView) convertView.findViewById(R.id.viewpager_next_tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.img.setImageResource(siftList.get(position).getImgid());
        viewHolder.content.setText(siftList.get(position).getContent());
        return convertView;
    }
    public class ViewHolder{
        ImageView img;
        TextView content;
    }
}
