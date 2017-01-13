package com.lmc.allpeople_tv;

import android.app.Application;

import com.tencent.smtt.sdk.TbsDownloader;

/**
 * 作者：Created by ${李泰亲} on 2017/1/13 15:39.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TbsDownloader.needDownload(getApplicationContext(), false);
    }
}
