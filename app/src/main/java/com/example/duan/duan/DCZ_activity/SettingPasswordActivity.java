package com.example.duan.duan.DCZ_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  设置密码
 *
 * */
public class SettingPasswordActivity extends BaseActivity {
    private SettingPasswordActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button1)
    TextView button1;           //修改登录密码
    @BindView(R.id.button2)
    TextView button2;           //修改支付密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);
        ButterKnife.bind(this);
        INSTANCE=this;
        setViews();
        setListener();
    }

    private void setViews() {

    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //修改登录密码
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, ChangeLoginPasswordActivity.class);
                startActivity(intent);
            }
        });
        //修改支付密码
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, ChangePayPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
