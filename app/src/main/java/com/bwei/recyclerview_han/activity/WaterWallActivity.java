package com.bwei.recyclerview_han.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.bwei.recyclerview_han.R;
import com.bwei.recyclerview_han.adapter.RvWaterWallAdapter;
import com.bwei.recyclerview_han.listenter.OnRecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * Author ${韩磊鑫} on 2017/3/21 19:30
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：瀑布流
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */
public class WaterWallActivity extends AppCompatActivity{

    RecyclerView rv;
    RvWaterWallAdapter rvWaterWallAdapter;
    ArrayList<String> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterwall);

        rv = (RecyclerView) findViewById(R.id.waterwall_rv);

        initData();

        //添加布局管理者
        rv.setLayoutManager(new StaggeredGridLayoutManager(4,RecyclerView.VERTICAL));

        rvWaterWallAdapter = new RvWaterWallAdapter(this,list);

        //添加适配器
        rv.setAdapter(rvWaterWallAdapter);

        rvWaterWallAdapter.setOnItemClickListenter(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(WaterWallActivity.this,"点击了"+position,Toast.LENGTH_LONG);
            }

            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(WaterWallActivity.this,"长按了"+position,Toast.LENGTH_LONG);

            }
        });
    }

    private void initData() {

        list = new ArrayList();

        for (int i = 0; i<=100 ; i++){

            list.add("核桃"+i);
        }
    }
    public void addItem(View view) {

        list.add(2, "新的条目");
        rvWaterWallAdapter.notifyItemInserted(2);
    }


    public void deleteItem(View view) {
        list.remove(3);
        rvWaterWallAdapter.notifyItemRemoved(3);
    }
}
