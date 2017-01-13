package com.lmc.allpeople_tv.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.lmc.allpeople_tv.Constants;
import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.bean.jsBean;
import com.lmc.lmc_library.util.OkHttp;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.io.IOException;

import okhttp3.Request;


public class DetailsActivity extends Activity {
    com.tencent.smtt.sdk.WebView tbsContent;
    private Toolbar det_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        det_toolbar = (Toolbar) findViewById(R.id.det_toolbar);
        det_toolbar.setTitle(title);

        //使用腾讯X5webview加载网页
        initView(id);
    }

    private void initView(String id) {
        tbsContent = (com.tencent.smtt.sdk.WebView) findViewById(R.id.wv_detail_content);
        tbsContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        WebSettings webSettings = tbsContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        getHttp(id);
        tbsContent.setWebViewClient(new WebViewClient() {
            // 防止加载网页时调起系统浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView var1, int var2, String var3, String var4) {
                Log.i("打印日志", "网页加载失败");
            }
        });
        //进度条
        tbsContent.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    Log.i("打印日志", "加载完成");
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (tbsContent != null && tbsContent.canGoBack()) {
                tbsContent.goBack();
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tbsContent != null) tbsContent.destroy();
    }

    public void getHttp(String id) {
        OkHttp.getAsync(Constants.Daily_url + id, new OkHttp.DataCallBack() {


            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                jsBean jsBean = gson.fromJson(result, jsBean.class);
                String body = jsBean.getBody();
                String htmlData = body;
                htmlData = htmlData.replaceAll("&", "");
                htmlData = htmlData.replaceAll("quot;", "\"");
                htmlData = htmlData.replaceAll("lt;", "<");
                htmlData = htmlData.replaceAll("gt;", ">");
                tbsContent.loadDataWithBaseURL(null, htmlData, "text/html", "utf-8", null);
            }
        });
    }
}
