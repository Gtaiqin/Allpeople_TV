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
import com.lmc.allpeople_tv.bean.WeixinBean;

import java.util.List;

/**
 * 作者：Created by ${李泰亲} on 2017/1/9 16:20.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class WeixinAdapter extends RecyclerView.Adapter<WeixinAdapter.ViewHolder> {
    private Context context;
    private List<WeixinBean.NewslistBean> mlist;

    public WeixinAdapter() {
    }

    public WeixinAdapter(Context context, List<WeixinBean.NewslistBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WeixinAdapter.ViewHolder holder = new WeixinAdapter.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.weixin_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_wechat_item_title.setText(mlist.get(position).getTitle());
        holder.tv_wechat_item_time.setText(mlist.get(position).getCtime());
        holder.tv_wechat_item_from.setText(mlist.get(position).getDescription());
        Glide.with(context).load(mlist.get(position).getPicUrl()).into(holder.iv_wechat_item_image);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_wechat_item_image;
        private TextView tv_wechat_item_title, tv_wechat_item_from, tv_wechat_item_time;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_wechat_item_image = (ImageView) itemView.findViewById(R.id.iv_wechat_item_image);
            tv_wechat_item_title = (TextView) itemView.findViewById(R.id.tv_wechat_item_title);
            tv_wechat_item_from = (TextView) itemView.findViewById(R.id.tv_wechat_item_from);
            tv_wechat_item_time = (TextView) itemView.findViewById(R.id.tv_wechat_item_time);
        }
    }
}
