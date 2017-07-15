package com.example.duan.duan.DCZ_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  人脸识别
 *
 * */
public class FaceKnowActivity extends BaseActivity {
    private FaceKnowActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button)
    TextView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_know);
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
                Intent intent=new Intent(INSTANCE,FaceCollectActivity.class);
                startActivity(intent);
            }
        });
    }
}
