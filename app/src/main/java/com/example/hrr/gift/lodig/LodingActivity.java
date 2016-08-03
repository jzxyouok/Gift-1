package com.example.hrr.gift.lodig;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseActivity;
import com.example.hrr.gift.gift.HomeActivity;

public class LodingActivity extends BaseActivity {
    ImageView imageView;

    @Override
    public void setlayout() {
        setContentView(R.layout.loding);
    }

    @Override
    public void getview() {
        imageView= (ImageView) findViewById(R.id.loding_img);
    }

    @Override
    public void setview() {
        imageView.setImageResource(R.mipmap.loding);
        sleep();
    }

    @Override
    public void onClick(View v) {

    }
    public void sleep(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(LodingActivity.this,HomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        }).start();
    }
}
