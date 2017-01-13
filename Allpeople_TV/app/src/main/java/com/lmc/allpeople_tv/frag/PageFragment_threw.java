package com.lmc.allpeople_tv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lmc.allpeople_tv.Constants;
import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.adapter.WeixinAdapter;
import com.lmc.allpeople_tv.bean.WeixinBean;
import com.lmc.lmc_library.util.OkHttp;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:48.
 * 邮箱：15711299361@163.com
 * 模块：微信模块
 */

public class PageFragment_threw extends Fragment {

    private RecyclerView weixin_rv_view;
    private SwipeRefreshLayout swiperefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_threw, container, false);
        weixin_rv_view = (RecyclerView) view.findViewById(R.id.weixin_rv_view);
        swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        weixin_rv_view.setNestedScrollingEnabled(false);
        weixin_rv_view.setLayoutManager(layoutManager);
        //请求网络数据
        getHttpData();
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpData();
            }
        });
        return view;
    }

    public void getHttpData() {
        OkHttp.getAsync(Constants.weixin_url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                WeixinBean weixinBean = gson.fromJson(result, WeixinBean.class);
                List<WeixinBean.NewslistBean> newslist = weixinBean.getNewslist();
                weixin_rv_view.setAdapter(new WeixinAdapter(getActivity(), newslist));
                swiperefresh.setRefreshing(false);
            }
        });
    }

}
