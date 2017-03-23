package com.bwei.recyclerview_han.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.holder.simple.RvSimpleHolder;
import com.bwei.recyclerview_han.listenter.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Author ${韩磊鑫} on 2017/3/21 19:42
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class RvWaterWallAdapter extends RecyclerView.Adapter<RvSimpleHolder> {

    private final Context context;
    private final ArrayList<String> list;
    private final ArrayList<Integer> height;
    private OnRecyclerViewItemClickListener onrecyclerViewItemClickListener;

    public RvWaterWallAdapter(Context context, ArrayList<String> list) {

        this.context = context;
        this.list = list;

        //定义当前控件的高度
        height = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            height.add((int) (100 + (int) 400 * Math.random()));
        }
    }

    public void setOnItemClickListenter(OnRecyclerViewItemClickListener onItemClickListenter) {

        this.onrecyclerViewItemClickListener = onItemClickListenter;
    }

    @Override
    public RvSimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //实例化布局View
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item, parent, false);

        RvSimpleHolder rvsh = new RvSimpleHolder(view);

        return rvsh;
    }

    @Override
    public void onBindViewHolder(RvSimpleHolder holder, final int position) {

        //重新定义trextView的高度
        //获取TextView在整个布局中的参数
        ViewGroup.LayoutParams layoutParams = holder.tv_item.getLayoutParams();
        layoutParams.height = height.get(position);

        //重新设置
        holder.tv_item.setLayoutParams(layoutParams);

        //设置控件的点击事件
        holder.tv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onrecyclerViewItemClickListener != null) {

                    onrecyclerViewItemClickListener.onItemClick(position);
                }
            }
        });

        //设置控件的长按事件、
        holder.tv_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onrecyclerViewItemClickListener != null) {

                    onrecyclerViewItemClickListener.onItemLongClick(position);
                }
                return true;
            }
        });

        // 随机颜色
        Random random = new Random();
        //#FFFFF0
        //int ranColor = 0xff000000 | random.nextInt(0x00ffffff);
        int[] ranColor = {0xffFFFFF0, 0xffF5FFFA, 0xffFFE7B,
                0xffF0F8FF, 0xffEECFA1, 0xffF5FFFA, 0xffFFF0F5, 0xffEEE9E9}; //0xff000000 | random.nextInt(0x00ffffff);
        int randomcolor = random.nextInt(ranColor.length);
        //int color = Color.argb(1, random.nextInt(255) / 255, random.nextInt(255) / 255, random.nextInt(255) / 255);
        holder.tv_item.setBackgroundColor(ranColor[randomcolor]);


        //设置文本内容
        holder.tv_item.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //移动
    public void onMove(int oldPosition, int newPosition) {

        //交换数据
        Collections.swap(list, oldPosition, newPosition);

        //刷新适配器
        this.notifyItemMoved(oldPosition, newPosition);
    }

    //删除
    public void onDelete(int adapterPosition) {

        list.remove(adapterPosition);

        this.notifyItemRemoved(adapterPosition);
    }
//compile 'com.mcxiaoke.volley:library:1.0.19'
}
