package com.example.duan.duan.DCZ_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  密保认证
 *
 * */

public class PhoneProveActivity extends Activity {
    private PhoneProveActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.button)
    View button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_prove);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
