package com.example.duan.duan.DCZ_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan.duan.R;

public class DFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_d, null);
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
        Log.i("dcz_DF","正在执行setUserVisibleHint");
        if(isVisibleToUser){
            Log.i("dcz_DF","正在显示此页面");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i("dcz_DF","正在执行onHiddenChanged");
    }

    private void setViews() {

    }

    private void setListener() {

    }
}
