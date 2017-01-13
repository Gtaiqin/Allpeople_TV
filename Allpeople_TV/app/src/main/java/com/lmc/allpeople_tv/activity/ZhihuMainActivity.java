package com.lmc.allpeople_tv.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.adapter.MyFragmentPagerAdapter;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:48.
 * 邮箱：15711299361@163.com
 * 模块：首页模块
 */
public class ZhihuMainActivity extends AutoLayoutActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_main);
        //ToolBar设置
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        //TabLayout+ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.zh_tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.zh_fragvp);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                this);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //侧滑菜单设置
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //设置抽屉布局内的视图
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.zhihu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_release) {
            // Handle the camera action
        } else if (id == R.id.nav_tv) {
            startActivity(TvActivity.class);
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_about) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startActivity(Class<? extends Activity> ActivityClass) {
        Intent intent = new Intent(this, ActivityClass);
        startActivity(intent);
    }
}
