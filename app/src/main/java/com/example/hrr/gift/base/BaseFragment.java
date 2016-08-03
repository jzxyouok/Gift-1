package com.example.hrr.gift.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by HRR on 2016/6/13.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onStart() {
        super.onStart();
        getview();
    }

    @Override
    public void onResume() {
        super.onResume();
        setview();
    }

    public abstract void getview();
    public abstract void setview();

}
