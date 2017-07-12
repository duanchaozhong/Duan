package com.example.duan.duan.DCZ_activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.duan.duan.DCZ_adapter.EquipmentAdapter;
import com.example.duan.duan.DCZ_adapter.OperationRecordAdapter;
import com.example.duan.duan.DCZ_bean.OperationRecordBean;
import com.example.duan.duan.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  操作记录
 *
 * */
public class OperationRecordActivity extends BaseActivity {
    private OperationRecordAdapter adapter;
    private OperationRecordActivity INSTANCE;
    private List<OperationRecordBean> list=new ArrayList();
    @BindView(R.id.listview)
    XRecyclerView lv;
    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_record);
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
            adapter=new OperationRecordAdapter(INSTANCE,list);
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
}
