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

import com.example.duan.duan.DCZ_activity.LoginActivity;
import com.example.duan.duan.R;

/**
 *  发现
 *
 * */
public class CFragment extends Fragment {
    private View view;
    private LinearLayout ll1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_c, null);
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
        Log.i("dcz_CF","正在执行setUserVisibleHint");
        if(isVisibleToUser){
            Log.i("dcz_CF","正在显示此页面");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i("dcz_CF","正在执行onHiddenChanged");
    }

    private void setViews() {
        ll1=(LinearLayout)view.findViewById(R.id.ll1);
    }

    private void setListener() {
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
