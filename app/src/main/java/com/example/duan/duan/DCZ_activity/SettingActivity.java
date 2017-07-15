package com.example.duan.duan.DCZ_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duan.duan.DCZ_lockdemo.LockUtil;
import com.example.duan.duan.DCZ_selft.SwitchButton;
import com.example.duan.duan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity {
    private SettingActivity INSTANCE;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.lock)
    LinearLayout lock;      //手势锁开启
    @BindView(R.id.tv_suo)
    TextView tv_suo;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.sdv1)
    SimpleDraweeView sdv1;
    @BindView(R.id.sdv2)
    SimpleDraweeView sdv2;
    @BindView(R.id.sdv3)
    SimpleDraweeView sdv3;
    @BindView(R.id.button1) //指纹密码
    SwitchButton button1;
    @BindView(R.id.button2) //人脸密码
    SwitchButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        INSTANCE=this;
        setWidth();
        setViews();
        setListener();
    }

    private void setViews() {

    }
    /**
     * 以下方法可以得到控件宽高
     * */
    private void setWidth(){
        ViewTreeObserver vto1 = sdv1.getViewTreeObserver();
        vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                sdv1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i("dcz3",sdv1.getWidth()+"");
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) sdv1.getLayoutParams();
                //获取当前控件的布局对象
                params.height=sdv1.getWidth();//设置当前控件布局的高度
                sdv1.setLayoutParams(params);//将设置好的布局参数应用到控件中
            }
        });
        ViewTreeObserver vto2 = sdv2.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                sdv2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i("dcz3",sdv2.getWidth()+"");
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) sdv2.getLayoutParams();
                //获取当前控件的布局对象
                params.height=sdv2.getWidth();//设置当前控件布局的高度
                sdv2.setLayoutParams(params);//将设置好的布局参数应用到控件中
            }
        });
        ViewTreeObserver vto3 = sdv3.getViewTreeObserver();
        vto3.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                sdv3.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i("dcz3",sdv3.getWidth()+"");
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) sdv3.getLayoutParams();
                //获取当前控件的布局对象
                params.height=sdv3.getWidth();//设置当前控件布局的高度
                sdv3.setLayoutParams(params);//将设置好的布局参数应用到控件中
            }
        });
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, LockActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(INSTANCE, LoginActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(LockUtil.getPwdStatus(INSTANCE)==true){
            tv_suo.setText("已开启");
        }else {
            tv_suo.setText("未开启");
        }
    }
}
