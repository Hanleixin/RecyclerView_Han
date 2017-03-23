package com.bwei.recyclerview_han.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.adapter.RvWaterWallAdapter;

import java.util.ArrayList;

/**
 * Author ${韩磊鑫} on 2017/3/22 14:26
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class RefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    RecyclerView rv;
    SwipeRefreshLayout sl;
    ArrayList<String> list;
    RvWaterWallAdapter rvWaterWallAdapter;

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_refresh);

        sl = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        rv = (RecyclerView) findViewById(R.id.refresh_rv);

        //添加数据
        initData();

        //布局管理者
        rv.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));

        //适配器
        rvWaterWallAdapter = new RvWaterWallAdapter(this,list);

        rv.setAdapter(rvWaterWallAdapter);

        //
        sl.setColorSchemeColors(Color.GRAY);

        //刷新的监听
        sl.setOnRefreshListener(this);
    }

    private void initData() {

        list = new ArrayList<>();

        for (int i = 0; i<1000 ; i++){
            list.add("葫芦"+i);
        }
    }

    @Override
    public void onRefresh() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //刷新条目
                list.add(0,"刷新^V^");
                //刷新适配器
                rvWaterWallAdapter.notifyDataSetChanged();
                //隐藏小圈圈
                sl.setRefreshing(false);
            }
        },2000);
    }
}
