package com.example.duan.duan.DCZ_activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.duan.duan.DCZ_adapter.EquipmentAdapter;
import com.example.duan.duan.DCZ_adapter.NewsAdapter;
import com.example.duan.duan.DCZ_bean.EquipmentBean;
import com.example.duan.duan.DCZ_bean.NewsBean;
import com.example.duan.duan.DCZ_util.DialogUtil;
import com.example.duan.duan.DCZ_util.HttpServiceClient;
import com.example.duan.duan.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *    设备管理
 *
 * */
public class EquipmentManageActivity extends BaseActivity {
    private EquipmentAdapter adapter;
    private EquipmentManageActivity INSTANCE;
    private Dialog dialog;
    private int pageNumber=1;
    private int pageSize=5;
    private List<EquipmentBean>list=new ArrayList();
    @BindView(R.id.listview)
    XRecyclerView lv;
    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_manage);
        ButterKnife.bind(this);
        INSTANCE=this;
        setViews();
        setListener();
    }

    /**
     *  数据初始化
     * */
    private void setViews() {
        if(adapter!=null){
            lv.loadMoreComplete();
            adapter.notify(list);
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(INSTANCE);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            lv.setLayoutManager(linearLayoutManager);
            lv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            lv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
            lv.setArrowImageView(R.mipmap.ic_launcher);
            //lv.addItemDecoration(new SpacesItemDecoration(20));
            adapter=new EquipmentAdapter(INSTANCE,list);
            lv.setAdapter(adapter);
        }
    }
    /**
     * 监听
     *
     * */
    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                lv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                lv.refreshComplete();
            }
        });
    }

    /***
     * 调取接口拿到服务器数据
     * */
    public void getData(){
        dialog= DialogUtil.createLoadingDialog(this,getString(R.string.loaddings));
        dialog.show();
        HttpServiceClient.getInstance().getNews("",pageNumber,pageSize).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                dialog.dismiss();
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        if(response.body().getCode()==200){
                       //     list = response.body().getData().getList();
                            pageNumber++;
                            pageSize=pageSize+5;
                            setViews();
                            setListener();
                        }else {
                            Toast.makeText(INSTANCE, "未知错误", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Log.d("dcz","返回的数据是空的");
                    }
                }else {
                    Log.d("dcz","获取数据失败");
                }
            }
            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                Toast.makeText(INSTANCE, "解析异常", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
