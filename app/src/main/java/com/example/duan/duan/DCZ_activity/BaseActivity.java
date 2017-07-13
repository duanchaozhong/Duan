package com.example.duan.duan.DCZ_activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.duan.duan.DCZ_util.StatusBarUtil;
import com.example.duan.duan.R;

import butterknife.ButterKnife;

/**
 * Created by duan on 2017/6/16.
 */

public class BaseActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setImgTransparent(this);      //这行是让标题沉浸
        Log.i("BaseActivity",getClass().getSimpleName());
    }
}
