package com.lmc.lmc_library.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * 作者：Created by ${李泰亲} on 2017/1/6 14:49.
 * 邮箱：15711299361@163.com
 * 模块：轮播图适配器
 */

public class CarouselPagerAdapter extends PagerAdapter {
    private List<ImageView> imgList;

    public CarouselPagerAdapter() {
        super();
    }

    public CarouselPagerAdapter(List<ImageView> imgList) {
        super();
        this.imgList = imgList;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = imgList.get(position % imgList.size());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
