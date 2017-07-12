package com.example.duan.duan.DCZ_activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.DCZ_selft.MiddleDialog;
import com.example.duan.duan.DCZ_util.DialogUtil;
import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  登录界面
 *
 **/
public class LoginActivity extends BaseActivity {
    private LoginActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button)
    View button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    DialogUtil.createLoadingDialog(INSTANCE,"登陆中","2").show();
                new MiddleDialog(INSTANCE, "账号或密码错误，请重新填写", new MiddleDialog.onButtonCLickListener2() {
                    @Override
                    public void onActivieButtonClick(Object bean, int position) {

                    }
                },R.style.registDialog).show();
            }
        });
    }
}
