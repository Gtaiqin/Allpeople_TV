package com.lmc.allpeople_tv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lmc.allpeople_tv.R;
import com.lmc.allpeople_tv.bean.MStoriesBean;

import java.util.List;

/**
 * 作者：Created by ${李泰亲} on 2017/1/6 21:28.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {
    private List<MStoriesBean> mlist;
    private Context context;

    public DailyAdapter(List<MStoriesBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.dailyrv_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_daily_item_title.setText(mlist.get(position).getTitle());
        Glide.with(context).load(mlist.get(position).getUrl()).into(holder.iv_daily_item_image);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_daily_item_image;
        private TextView tv_daily_item_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_daily_item_image = (ImageView) itemView.findViewById(R.id.iv_daily_item_image);
            tv_daily_item_title = (TextView) itemView.findViewById(R.id.tv_daily_item_title);
        }
    }
}
