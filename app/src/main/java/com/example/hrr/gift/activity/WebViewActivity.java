package com.example.hrr.gift.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hrr.gift.R;
import com.example.hrr.gift.base.BaseActivity;

/**
 * Created by HRR on 2016/6/17.
 */
public class WebViewActivity extends BaseActivity {
    WebView webView;
    Intent intent;
    String inputurl;
    @Override
    public void setlayout() {
        setContentView(R.layout.webview);
    }

    @Override
    public void getview() {
        webView= (WebView) findViewById(R.id.webview_webview);
        intent=getIntent();
    }

    @Override
    public void setview() {
        if (intent!=null){
            Bundle b =intent.getExtras();
            inputurl=b.getString("url","www.baidu.com");
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(inputurl);
    }

    @Override
    public void onClick(View v) {

    }
}
