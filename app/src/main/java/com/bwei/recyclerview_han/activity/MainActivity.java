package com.bwei.recyclerview_han.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bwei.recyclerview_han.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取相关控件
        ListView lv = (ListView) findViewById(R.id.main_listview_lv);

        //添加视图
        initData();

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        lv.setOnItemClickListener(this);
    }

    /**
     * 添加视图
     */
    private void initData() {

        list = new ArrayList<>();

        list.add("单行 多行 单横 多横");
        list.add("瀑布流效果 条目动画");
        list.add("多条目效果展示");
        list.add("条目拖动删除效果");
        list.add("上拉舒心下拉加载效果");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {

            case 0:
                enterActivity(SimpleActivity.class);//单行 多行 单横 多横
                break;
            case 1:
                enterActivity(WaterWallActivity.class);//瀑布流效果 条目动画
                break;
            case 2:
                enterActivity(MoreItemActivity.class);//多条目效果展示
                break;
            case 3:
                enterActivity(RemoveActivity.class);
                break;
            case 4:
                enterActivity(RefreshActivity.class);
                break;
        }
    }

    public void enterActivity(Class clazz) {

        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
