package com.lmc.allpeople_tv.frag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lmc.allpeople_tv.Constants;
import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.activity.DetailsActivity;
import com.lmc.allpeople_tv.adapter.DailyAdapter;
import com.lmc.allpeople_tv.bean.DailyBean;
import com.lmc.allpeople_tv.bean.MStoriesBean;
import com.lmc.lmc_library.adapter.CarouselPagerAdapter;
import com.lmc.lmc_library.util.OkHttp;
import com.lmc.lmc_library.view.ChildViewPager;
import com.lmc.lmc_library.view.RecyclerViewClickListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:48.
 * 邮箱：15711299361@163.com
 * 模块：日报模块
 */

public class PageFragment_one extends Fragment {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 0:
                    int currentItem = child_vp.getCurrentItem();
                    currentItem++;
                    child_vp.setCurrentItem(currentItem);
                    vp_text.setText(tvlist.get(currentItem % tvlist.size()));
                    break;
                default:
                    break;
            }
        }
    };
    private ChildViewPager child_vp;
    private ArrayList<ImageView> imglist;
    private ArrayList<String> tvlist;
    private RecyclerView rv_view;
    private NestedScrollView nsv;
    private TextView vp_text;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_one, container, false);
        child_vp = (ChildViewPager) view.findViewById(R.id.child_vp);
        rv_view = (RecyclerView) view.findViewById(R.id.rv_view);
        nsv = (NestedScrollView) view.findViewById(R.id.nsv);
        vp_text = (TextView) view.findViewById(R.id.vp_text);
        //悬浮按钮设置
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "This is Snackbar!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                nsv.scrollTo(0, 0);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_view.setNestedScrollingEnabled(false);
        rv_view.setLayoutManager(linearLayoutManager);
        //请求网络数据
        getHttpData();
        //viewpager滑动监听
        setPagerListener();
        return view;
    }

    //请求网络数据
    public void getHttpData() {
        OkHttp.getAsync(Constants.Daily_url + "latest", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                DailyBean dailyBean = gson.fromJson(result, DailyBean.class);
                List<DailyBean.TopStoriesBean> top_stories = dailyBean.getTop_stories();
                imglist = new ArrayList<ImageView>();
                tvlist = new ArrayList<String>();
                for (int i = 0; i < top_stories.size(); i++) {
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(getActivity()).load(top_stories.get(i).getImage()).into(imageView);
                    imglist.add(imageView);
                    tvlist.add(top_stories.get(i).getTitle());
                }
                List<MStoriesBean> mStorieslist = new ArrayList<MStoriesBean>();
                List<DailyBean.StoriesBean> stories = dailyBean.getStories();
                for (int i = 0; i < stories.size(); i++) {
                    MStoriesBean s = new MStoriesBean();
                    String title = stories.get(i).getTitle();
                    String imgurl = stories.get(i).getImages().get(0);
                    s.setTitle(title);
                    s.setUrl(imgurl);
                    mStorieslist.add(s);
                }
                rv_view.setAdapter(new DailyAdapter(mStorieslist, getActivity()));
                setListener(stories);
                //添加ViewPager适配器
                child_vp.setAdapter(new CarouselPagerAdapter(imglist));
                vp_text.setText(tvlist.get(0));
                change_pager();
            }
        });
    }

    private void setListener(final List<DailyBean.StoriesBean> mlist) {
        rv_view.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), rv_view,
                new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), DetailsActivity.class);
                        intent.putExtra("id", mlist.get(position).getId() + "");
                        intent.putExtra("title", mlist.get(position).getTitle());
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(getActivity(), "Long Click ", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    //viewpager滑动监听
    private void setPagerListener() {
        child_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp_text.setText(tvlist.get(position % tvlist.size()));
                change_pager();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    //手指滑动状态
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.removeCallbacksAndMessages(null);
                        break;
                    //停止状态
                    case ViewPager.SCROLL_STATE_IDLE:
                        break;
                    //自动滑动状态
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    // handler发送延时消息更新viewpager页面
    public void change_pager() {
        handler.sendEmptyMessageDelayed(0, 3000);
    }

}