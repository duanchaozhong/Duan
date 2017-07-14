package com.example.duan.duan.DCZ_activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.duan.DCZ_application.MyApplication;
import com.example.duan.duan.DCZ_lockdemo.CustomLockView;
import com.example.duan.duan.DCZ_lockdemo.LockUtil;
import com.example.duan.duan.DCZ_lockdemo.ScreenObserver;
import com.example.duan.duan.MainActivity;
import com.example.duan.duan.R;
/**
 *  手势解锁页面
 *
 * */
public class LoginLockActivity extends BaseActivity {
    public Context context;
    public <K extends View> K getViewById(int id) {
        return (K) getWindow().findViewById(id);
    }
    private ScreenObserver mScreenObserver;
    private TextView tvWarn;
    private int[] mIndexs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_lock);
        context=this;
        mScreenObserver = new ScreenObserver(this);
        mScreenObserver.requestScreenStateUpdate(new ScreenObserver.ScreenStateListener() {
            @Override
            public void onScreenStateChange(boolean isScreenOn) {
                if (!isScreenOn&& LockUtil.getPwdStatus(context)&& LockUtil.getPwd(context).length>0) {
                    doSomethingOnScreenOff();
                }
            }
        });
        initView();
        mIndexs= LockUtil.getPwd(this);
        //判断当前是否设置过密码，没有设置过，直接跳转到设置手势密码页面
        if(mIndexs.length>1){
            final CustomLockView cl=(CustomLockView)findViewById(R.id.cl);
            cl.setmIndexs(mIndexs);
            cl.setErrorTimes(4);
            cl.setStatus(1);
            cl.setShow(false);
            cl.setOnCompleteListener(new CustomLockView.OnCompleteListener() {
                @Override
                public void onComplete(int[] indexs) {
                    Toast.makeText(LoginLockActivity.this,"输入正确",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginLockActivity.this, MainActivity.class);
                    startActivity(intent);
                    MyApplication.suo=false;
                    finish();
                }

                @Override
                public void onError() {
                    if (cl.getErrorTimes() > 0) {
                        tvWarn.setText("密码错误，还可以再输入" + cl.getErrorTimes() + "次");
                        tvWarn.setTextColor(getResources().getColor(R.color.red));
                    }
                }
            });
        }
    }


    @Override
    protected void onDestroy() {
        if(mScreenObserver!=null){
            mScreenObserver.stopScreenStateUpdate();
        }
        super.onDestroy();
    }

    /**
     * 打开验证手势
     */
    private void doSomethingOnScreenOff() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), LoginLockActivity.class);
        intent.putExtra("current","resume");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        tvWarn=getViewById(R.id.tvWarn);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
}
