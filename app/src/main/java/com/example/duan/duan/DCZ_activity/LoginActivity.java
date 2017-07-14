package com.example.duan.duan.DCZ_activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    TextView button;           //下一步
    @BindView(R.id.button2)
    View button2;           //找回密码
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
                Intent intent=new Intent(INSTANCE, PhoneProveActivity.class);
                startActivity(intent);
      /*      //    DialogUtil.createLoadingDialog(INSTANCE,"登陆中","2").show();
                new MiddleDialog(INSTANCE, "账号或密码错误，请重新填写", new MiddleDialog.onButtonCLickListener2() {
                    @Override
                    public void onActivieButtonClick(Object bean, int position) {

                    }
                },R.style.registDialog).show();*/
            }
        });
        //密保认证
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
