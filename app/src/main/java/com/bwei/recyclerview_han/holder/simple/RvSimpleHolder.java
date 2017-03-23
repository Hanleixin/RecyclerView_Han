package com.bwei.recyclerview_han.holder.simple;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwei.recyclerview_han.R;

/**
 * Author ${韩磊鑫} on 2017/3/21 14:22
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class RvSimpleHolder extends RecyclerView.ViewHolder {

    public final TextView tv_item;

    public RvSimpleHolder(View itemView) {
        super(itemView);

        tv_item = (TextView) itemView.findViewById(R.id.tv_item);
    }
}
