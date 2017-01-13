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
import com.lmc.allpeople_tv.bean.SpecialBean;

import java.util.List;

/**
 * 作者：Created by ${李泰亲} on 2017/1/9 16:20.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.ViewHolder> {
    private Context context;
    private List<SpecialBean.DataBean> mlist;

    public SpecialAdapter() {
    }

    public SpecialAdapter(Context context, List<SpecialBean.DataBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SpecialAdapter.ViewHolder holder = new SpecialAdapter.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.specialrc_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.section_kind.setText(mlist.get(position).getName());
        holder.section_des.setText(mlist.get(position).getDescription());
        Glide.with(context).load(mlist.get(position).getThumbnail()).into(holder.section_bg);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView section_bg;
        private TextView section_kind, section_des;

        public ViewHolder(View itemView) {
            super(itemView);
            section_bg = (ImageView) itemView.findViewById(R.id.section_bg);
            section_kind = (TextView) itemView.findViewById(R.id.section_kind);
            section_des = (TextView) itemView.findViewById(R.id.section_des);
        }
    }
}
