package com.lmc.allpeople_tv.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lmc.allpeople_tv.frag.PageFragment_one;
import com.lmc.allpeople_tv.frag.PageFragment_threw;
import com.lmc.allpeople_tv.frag.PageFragment_two;


/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:50.
 * 邮箱：15711299361@163.com
 * 模块：首页ViewPager适配器
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 3;
    private String[] titles = new String[]{"日报", "专栏", "微信"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PageFragment_one();
                break;
            case 1:
                fragment = new PageFragment_two();
                break;
            case 2:
                fragment = new PageFragment_threw();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
