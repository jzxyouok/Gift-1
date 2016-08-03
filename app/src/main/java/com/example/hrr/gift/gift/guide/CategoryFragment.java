package com.example.hrr.gift.gift.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseFragment;
import com.example.hrr.gift.utils.Tools;

/**
 * Created by HRR on 2016/6/14.
 */
public class CategoryFragment extends BaseFragment {
    View view,view_top;
    ImageView category_left;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.category,null);
        return view;
    }

    @Override
    public void getview() {
        view_top=view.findViewById(R.id.category_top);
        category_left= (ImageView) view.findViewById(R.id.top_left_iv);

    }

    @Override
    public void setview() {
        Tools.settop(view_top,"分类",getActivity());
        category_left.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

    }
}
