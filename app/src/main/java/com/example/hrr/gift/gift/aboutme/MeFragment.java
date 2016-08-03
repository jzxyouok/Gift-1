package com.example.hrr.gift.gift.aboutme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseFragment;
import com.example.hrr.gift.entity.User;
import com.example.hrr.gift.utils.UserManger;

/**
 * Created by HRR on 2016/6/15.
 */
public class MeFragment extends BaseFragment {
    View view;
    ImageView head_iv;
    TextView name_tv;
    UserManger userManger;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.aboutmy,null);
        return view;
    }

    @Override
    public void getview() {
        head_iv= (ImageView) getActivity().findViewById(R.id.aboutme_head);
        name_tv= (TextView) getActivity().findViewById(R.id.aboutme_username);
        userManger=new UserManger(getActivity());
    }

    @Override
    public void setview() {
        User user;
        user=userManger.getuser();
        if(user.getName()!=null){
            String name=user.getName() ;
            name_tv.setText(name);
            head_iv.setImageResource(R.mipmap.ic_gender_boy);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
