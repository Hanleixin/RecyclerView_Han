package com.bwei.recyclerview_han.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.holder.simple.RvSimpleHolder;

import java.util.ArrayList;

/**
 * Author ${韩磊鑫} on 2017/3/21 14:26
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class RvSimpleAdapter extends RecyclerView.Adapter<RvSimpleHolder> {

    Context context;
    ArrayList<String> list;

    public RvSimpleAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RvSimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //实例化布局
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item,parent,false);

        RvSimpleHolder rvsh = new RvSimpleHolder(view);

        return rvsh;
    }

    @Override
    public void onBindViewHolder(RvSimpleHolder holder, int position) {

        holder.tv_item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}