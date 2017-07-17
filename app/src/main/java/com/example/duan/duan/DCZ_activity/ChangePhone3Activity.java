package com.example.duan.duan.DCZ_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duan.duan.DCZ_adapter.CityAdapter;
import com.example.duan.duan.DCZ_bean.CityBean;
import com.example.duan.duan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  更换密保手机（身份证验证）
 *
 * */
public class ChangePhone3Activity extends BaseActivity {
    private ChangePhone3Activity INSTANCE;
    public static CityBean bean;
    public static String content="+86 ";
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button)
    View button;
    @BindView(R.id.city)
    TextView city;           //选择地区和国家
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.rl_zheng)
    SimpleDraweeView zheng;   //身份证正面
    @BindView(R.id.rl_fan)
    SimpleDraweeView fan;
    @BindView(R.id.rl_shou)
    SimpleDraweeView shou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone3);
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
                Intent intent=new Intent(INSTANCE, ChangePhone4Activity.class);
                startActivity(intent);
            }
        });
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, CityListActivity.class);
                startActivity(intent);
            }
        });
        zheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        shou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        city.setText(content);
    }
}
