package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.DCZ_util.ActivityUtils;
import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  修改登录密码
 *
 * */

public class ChangeLoginPasswordActivity extends BaseActivity {
    private ChangeLoginPasswordActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_password);
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
                ActivityUtils.getInstance().popActivity(INSTANCE);
            }
        });
    }
}
