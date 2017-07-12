package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.DCZ_selft.SwitchButton;
import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  钱包保护
 *
 * */
public class WalletProtectActivity extends BaseActivity{
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button1)
    SwitchButton button1;
    @BindView(R.id.button2)
    SwitchButton button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_protect);
        ButterKnife.bind(this);
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
