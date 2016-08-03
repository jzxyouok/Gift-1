package com.example.hrr.gift.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by HRR on 2016/6/13.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setlayout();
        getview();
        setview();
    }
    public abstract void setlayout();
    public abstract void getview();
    public abstract void setview();
}
