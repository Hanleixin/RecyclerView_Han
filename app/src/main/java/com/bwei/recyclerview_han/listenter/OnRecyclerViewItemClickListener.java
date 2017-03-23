package com.bwei.recyclerview_han.listenter;

/**
 * Author ${韩磊鑫} on 2017/3/22 09:04
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public interface OnRecyclerViewItemClickListener {

    //（接口）定义抽象方法
    void onItemClick(int position);
    void onItemLongClick(int position);
}
