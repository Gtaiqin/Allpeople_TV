package com.lmc.allpeople_tv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lmc.allpeople_tv.Constants;
import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.adapter.SpecialAdapter;
import com.lmc.allpeople_tv.bean.SpecialBean;
import com.lmc.lmc_library.util.OkHttp;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：Created by ${李泰亲} on 2017/1/5 11:48.
 * 邮箱：15711299361@163.com
 * 模块：专栏模块
 */

public class PageFragment_two extends Fragment {

    private RecyclerView special_rv_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_two, container, false);
        special_rv_view = (RecyclerView) view.findViewById(R.id.Special_rv_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        special_rv_view.setNestedScrollingEnabled(false);
        special_rv_view.setLayoutManager(gridLayoutManager);
        //请求网络数据
        getHttpData();
        return view;
    }

    public void getHttpData() {
        OkHttp.getAsync(Constants.Special_url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                SpecialBean specialBean = gson.fromJson(result, SpecialBean.class);
                List<SpecialBean.DataBean> data = specialBean.getData();
                special_rv_view.setAdapter(new SpecialAdapter(getActivity(), data));
            }
        });
    }
}
