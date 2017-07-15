package com.example.duan.duan.DCZ_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.duan.duan.R;

import butterknife.BindView;

/**
 *      选择国家和地区
 *
 * */
public class CityListActivity extends BaseActivity {
    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
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
    }
}
