package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  我的足迹
 *
 * */
public class FootprintsActivity extends BaseActivity{
    private FootprintsActivity INSTANCE;
    @BindView(R.id.back)
    View back;
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
