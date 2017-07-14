package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.DCZ_adapter.Footprints1Adapter;
import com.example.duan.duan.DCZ_adapter.Footprints2Adapter;
import com.example.duan.duan.DCZ_bean.FootprintsBean;
import com.example.duan.duan.DCZ_selft.GridViewForScrollView;
import com.example.duan.duan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  我的足迹
 *
 * */
public class FootprintsActivity extends BaseActivity{
    private FootprintsActivity INSTANCE;
    private Footprints1Adapter adapter1;
    private Footprints2Adapter adapter2;
    private List<FootprintsBean>list=new ArrayList<>();
    @BindView(R.id.back)
    View back;
    @BindView(R.id.lv1)
    GridViewForScrollView lv1;
    @BindView(R.id.lv2)
    GridViewForScrollView lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprints);
        ButterKnife.bind(this);
        INSTANCE=this;
        setViews();
        setListener();
    }

    /**
     *  数据初始化
     * */
    private void setViews() {
        adapter1=new Footprints1Adapter(INSTANCE,list);
        lv1.setAdapter(adapter1);
        adapter2=new Footprints2Adapter(INSTANCE,list);
        lv2.setAdapter(adapter2);
    }
    /**
     * 监听
     *
     * */
    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
