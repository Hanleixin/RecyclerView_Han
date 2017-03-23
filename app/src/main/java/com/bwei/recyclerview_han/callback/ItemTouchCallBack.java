package com.bwei.recyclerview_han.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.bwei.recyclerview_han.adapter.RvWaterWallAdapter;

/**
 * Author ${韩磊鑫} on 2017/3/22 08:46
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class ItemTouchCallBack extends ItemTouchHelper.Callback{

    private RvWaterWallAdapter rvWaterWallAdapter;


    public void setAdapter(RvWaterWallAdapter rvWaterWallAdapter){

        this.rvWaterWallAdapter = rvWaterWallAdapter;
    }

    @Override/**获取滑动标记的方法*/
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        //拖动改变位置的标记
        int dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        //滑动删除的标记
        int swipeFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        return makeMovementFlags(dragFlag,swipeFlag);
    }

    @Override/**交换、移动位置的方法*/
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();

        rvWaterWallAdapter.onMove(oldPosition,newPosition);

        return true;
    }

    @Override/**删除的方法*/
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        //移除
        rvWaterWallAdapter.onDelete(viewHolder.getAdapterPosition());
    }
}
