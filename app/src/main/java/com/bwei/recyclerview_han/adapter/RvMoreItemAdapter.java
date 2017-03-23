package com.bwei.recyclerview_han.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.holder.moreitem.RvFirstTypeHolder;
import com.bwei.recyclerview_han.holder.moreitem.RvSecondTypeHolder;
import com.bwei.recyclerview_han.holder.moreitem.RvThirdTypeHolder;

/**
 * Author ${韩磊鑫} on 2017/3/21 22:43
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class RvMoreItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final String s;

    private static final int FIRST_TYPE = 0;
    private static final int SECOND_TYPE = 1;
    private static final int THIRD_TYPE = 2;

    private int type = FIRST_TYPE;

    public RvMoreItemAdapter(Context context, String s) {

        this.context = context;
        this.s = s;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position){

            case 0:
                type = FIRST_TYPE;
                break;

            case 1:
                type = SECOND_TYPE;
                break;

            case 2:
                type = THIRD_TYPE;
                break;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder v = null;

        switch (viewType){

            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.moreitem_frist,parent,false);
                v = new RvFirstTypeHolder(view);
                break;
            case 1:
                View view2 = LayoutInflater.from(context).inflate(R.layout.moreitem_second,parent,false);
                v = new RvSecondTypeHolder(view2);
                break;
            case 2:
                View view3 = LayoutInflater.from(context).inflate(R.layout.moreitem_thrid,parent,false);
                v = new RvThirdTypeHolder(view3);
                break;

        }

        return v;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //获取条目类型
        int itemViewType = getItemViewType(position);

        switch (itemViewType){

            case 0:
                break;
            case 1:

                break;
            case 2:
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

