package com.example.duan.duan.DCZ_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.duan.duan.DCZ_application.MyApplication;
import com.example.duan.duan.DCZ_lockdemo.LockUtil;
import com.example.duan.duan.MainActivity;
import com.example.duan.duan.R;
/**
 *  APP启动页
 *
 * */
public class AppStartActivity extends Activity {
    private int[] mIndexs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        suo();
    }

    private void suo() {
        mIndexs= LockUtil.getPwd(this);
        //判断当前是否设置过密码
        if(mIndexs.length>1&&MyApplication.suo==true){
            Intent intent=new Intent(this,LoginLockActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(AppStartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
