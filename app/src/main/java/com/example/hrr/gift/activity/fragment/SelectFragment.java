package com.example.hrr.gift.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseFragment;
import com.example.hrr.gift.utils.Tools;

/**
 * Created by HRR on 2016/6/14.
 */
public class SelectFragment extends BaseFragment {
    View view,viewtop;
    ImageView select_left;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.select,null);
        return view;
    }

    @Override
    public void getview() {
        viewtop=view.findViewById(R.id.selece_top);
        select_left= (ImageView) view.findViewById(R.id.top_left_iv);
    }

    @Override
    public void setview() {
        Tools.settop(viewtop,"热门",getActivity());
        select_left.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

    }
}
