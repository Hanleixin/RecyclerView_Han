package com.bwei.recyclerview_han.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.adapter.RvSimpleAdapter;

import java.util.ArrayList;

/**
 * Author ${韩磊鑫} on 2017/3/21 14:09
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class SimpleActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<String> list;
    RvSimpleAdapter rvSimleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple);

        //查找相关控件
        rv = (RecyclerView) findViewById(R.id.simple_recyclerview_rv);

        //准备数据
        initData();

        //添加布局管理者
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvSimleAdapter = new RvSimpleAdapter(this,list);

        //添加适配器
        rv.setAdapter(rvSimleAdapter);
    }

    private void initData() {

        list = new ArrayList<>();

        for (int i = 0; i <=1000;i ++ ){

            list.add("核桃"+i);
        }
    }

    /**单列添加数据*/
    public void singLine(View view) {

        rv.setLayoutManager(new LinearLayoutManager(this));

        //刷新适配器
        rvSimleAdapter.notifyDataSetChanged();
    }

    /**多列添加数据*/
    public void moreLine(View view) {

        rv.setLayoutManager(new GridLayoutManager(this,3));

        //刷新适配器
        rvSimleAdapter.notifyDataSetChanged();
    }

    /**单行添加数据*/
    public void singHorizontal(View view) {

        rv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        //刷新适配器
        rvSimleAdapter.notifyDataSetChanged();
    }

    /**多行添加数据*/
    public void moreHorizontal(View view) {

        rv.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false));

        //刷新适配器
        rvSimleAdapter.notifyDataSetChanged();
    }
}
