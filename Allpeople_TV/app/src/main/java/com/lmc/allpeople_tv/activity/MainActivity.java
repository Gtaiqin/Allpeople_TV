package com.lmc.allpeople_tv.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.lmc.allpeople_tv.R;
import com.lmc.lmc_library.Activity.BaseActivity;
import com.lmc.lmc_library.Activity.PermissionListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:48.
 * 邮箱：15711299361@163.com
 * 模块：导航页，6.0权限
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置去掉手机的顶部时间、日期等栏目
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //6.0申请权限
        setPermission();
    }

    //6.0申请权限
    private void setPermission() {
        requestRuntimePermission(new String[]{Manifest.permission.CAMERA}, new PermissionListener() {
            @Override
            public void onGranted() {
                //延时跳转
                initView();
            }

            @Override
            public void onDenied(List<String> deniedPermission) {
                for (int i = 0; i < deniedPermission.size(); i++) {
                    Toast.makeText(MainActivity.this, deniedPermission.get(i).toString() + "权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                //延时跳转
                initView();
            }
        });
    }

    public void initView() {
        Observable.timer(3000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent(MainActivity.this, ZhihuMainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
