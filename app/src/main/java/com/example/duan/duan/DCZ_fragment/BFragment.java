package com.example.duan.duan.DCZ_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duan.duan.DCZ_activity.ChangePhoneActivity;
import com.example.duan.duan.DCZ_activity.ChangeProtectActivity;
import com.example.duan.duan.DCZ_activity.EquipmentManageActivity;
import com.example.duan.duan.DCZ_activity.FootprintsActivity;
import com.example.duan.duan.DCZ_activity.GameProtectActivity;
import com.example.duan.duan.DCZ_activity.HaveActivity;
import com.example.duan.duan.DCZ_activity.OperationRecordActivity;
import com.example.duan.duan.DCZ_activity.ScanActivity;
import com.example.duan.duan.DCZ_activity.SettingPasswordActivity;
import com.example.duan.duan.DCZ_activity.ShopProtectActivity;
import com.example.duan.duan.DCZ_activity.WalletProtectActivity;
import com.example.duan.duan.DCZ_selft.MiddleDialog;
import com.example.duan.duan.DCZ_util.StatusBarUtil;
import com.example.duan.duan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  安全中心
 *
 * */
public class BFragment extends Fragment {
    private View view;
    @BindView(R.id.number1)
    TextView number1;
    @BindView(R.id.number2)
    TextView number2;
    @BindView(R.id.number3)
    TextView number3;
    @BindView(R.id.number4)
    TextView number4;
    @BindView(R.id.number5)
    TextView number5;
    @BindView(R.id.number6)
    TextView number6;
    @BindView(R.id.scan)
    LinearLayout scan;      //钱包保护
    @BindView(R.id.ll1)
    LinearLayout ll1;       //钱包保护
    @BindView(R.id.ll2)
    LinearLayout ll2;       //商城保护
    @BindView(R.id.ll3)
    LinearLayout ll3;       //兑换保护
    @BindView(R.id.ll4)
    LinearLayout ll4;       //游戏保护
    @BindView(R.id.ll5)
    LinearLayout ll5;       //安全手机
    @BindView(R.id.ll6)
    LinearLayout ll6;       //一键锁号
    @BindView(R.id.ll7)
    LinearLayout ll7;       //设置密码
    @BindView(R.id.ll8)
    LinearLayout ll8;       //安全邮箱
    @BindView(R.id.ll9)
    LinearLayout ll9;       //我的足迹
    @BindView(R.id.ll10)
    LinearLayout ll10;      //操作记录
    @BindView(R.id.ll11)
    LinearLayout ll11;      //设备管理

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StatusBarUtil.setImgTransparent(getActivity());      //这行是让标题沉浸
        view = View.inflate(getActivity(), R.layout.fragment_b, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViews();
        setListener();
    }

    /**
     * 懒加载
     * */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("dcz_BF","正在执行setUserVisibleHint");
        if(isVisibleToUser){
            Log.i("dcz_BF","正在显示此页面");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i("dcz_BF","正在执行onHiddenChanged");
    }

    private void setViews() {

    }

    private void setListener() {
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HaveActivity.class);
                startActivity(intent);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MiddleDialog(getActivity(), "动态密码", new MiddleDialog.onButtonCLickListener2() {
                    @Override
                    public void onActivieButtonClick(Object bean, int position) {

                    }
                },R.style.registDialog).show();
            }
        });
        /**
         *  扫码
         * */
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ScanActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  钱包保护
         * */
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), WalletProtectActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  商城保护
         * */
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ShopProtectActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  兑换保护
         * */
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChangeProtectActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  游戏保护
         * */
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GameProtectActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  安全手机
         * */
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChangePhoneActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  一键锁号
         * */
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         *  设置密码
         * */
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SettingPasswordActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  安全邮箱
         * */
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         *  我的足迹
         * */
        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FootprintsActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  操作记录
         * */
        ll10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OperationRecordActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  设备管理
         * */
        ll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), EquipmentManageActivity.class);
                startActivity(intent);
            }
        });
    }
}
