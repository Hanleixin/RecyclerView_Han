package com.bwei.recyclerview_han.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.adapter.RvWaterWallAdapter;
import com.bwei.recyclerview_han.callback.ItemTouchCallBack;

import java.util.ArrayList;

/**
 * Author ${韩磊鑫} on 2017/3/22 08:26
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class RemoveActivity extends AppCompatActivity {

    RecyclerView rv;
    RvWaterWallAdapter rvWaterWallAdapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_remove);
        //找控件
        rv = (RecyclerView) findViewById(R.id.remove_rv);
        //添加数据
        initData();
        //布局管理者
        rv.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));

        rvWaterWallAdapter = new RvWaterWallAdapter(this, list);
        //适配器
        rv.setAdapter(rvWaterWallAdapter);

        //创建回调
        ItemTouchCallBack itemTouchCallBak = new ItemTouchCallBack();

        //添加帮助类
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallBak);

        //进行关联
        itemTouchHelper.attachToRecyclerView(rv);

        itemTouchCallBak.setAdapter(rvWaterWallAdapter);
    }

    /**
     * 添加数据
     */
    private void initData() {

        list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add("核桃" + i);
        }
    }
}
