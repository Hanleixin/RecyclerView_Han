package com.bwei.recyclerview_han.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.adapter.RvMoreItemAdapter;

/**
 * Author ${韩磊鑫} on 2017/3/21 22:36
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class MoreItemActivity extends AppCompatActivity{

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreitem);

        ///查找相关控件
        rv = (RecyclerView) findViewById(R.id.moreitem_rv);

        //管理者
        rv.setLayoutManager(new LinearLayoutManager(this));

        //适配器
        rv.setAdapter(new RvMoreItemAdapter(this,""));

    }
}
