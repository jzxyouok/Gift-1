package com.example.hrr.gift.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrr.gift.R;

/**
 * Created by HRR on 2016/6/13.
 */
public class Tools {
    public static void settop(View view, String topname, final Activity a){
        ImageView imright = (ImageView) view.findViewById(R.id.top_right_iv);
        TextView tv = (TextView) view.findViewById(R.id.top_name_tv);
        ImageView imleft= (ImageView) view.findViewById(R.id.top_left_iv);
        tv.setText(topname);

    }
}
