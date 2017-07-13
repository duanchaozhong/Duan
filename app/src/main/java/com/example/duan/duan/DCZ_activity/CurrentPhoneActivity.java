package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  当前密保手机
 *
 * */
public class CurrentPhoneActivity extends BaseActivity{
    private CurrentPhoneActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_phone);
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
