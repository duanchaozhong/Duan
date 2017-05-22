package com.example.duan.duan.DCZ_fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.duan.duan.DCZ_bean.StatusBean;
import com.example.duan.duan.DCZ_util.DialogUtil;
import com.example.duan.duan.DCZ_util.HttpServiceClient;
import com.example.duan.duan.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AFragment extends Fragment {
    private View view;
    private Dialog dialog;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_a, null);
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
        Log.i("dcz_AF","正在执行setUserVisibleHint");
        if(isVisibleToUser){
            Log.i("dcz_AF","正在显示此页面");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i("dcz_AF","正在执行onHiddenChanged");
    }

    private void setViews() {
    //    tv= (TextView) view.findViewById(R.id.tv);
    }

    private void setListener() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private  void getData(){
        dialog= DialogUtil.createLoadingDialog(getActivity(),getString(R.string.loaddings));
        dialog.show();
        HttpServiceClient.getInstance().jiekou("1326263872").enqueue(new Callback<StatusBean>() {
            @Override
            public void onResponse(Call<StatusBean> call, Response<StatusBean> response) {
                dialog.dismiss();
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(), "返回数据成功", Toast.LENGTH_SHORT).show();
                    if(response.body()!=null){
                        Log.d("dcz",response.body().toString());
                    }else {
                        Log.d("dcz","返回的是空的");
                    }
                }else{
                    Log.d("dcz","获取数据失败");
                }
            }
            @Override
            public void onFailure(Call<StatusBean> call, Throwable t) {
                Log.d("dcz","数据解析失败");
            }
        });
    }
}
