package com.example.duan.duan.DCZ_fragment;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan.duan.DCZ_adapter.NewsAdapter;
import com.example.duan.duan.DCZ_bean.NewsBean;
import com.example.duan.duan.DCZ_util.DialogUtil;
import com.example.duan.duan.DCZ_util.HttpServiceClient;
import com.example.duan.duan.DCZ_util.StatusBarUtil;
import com.example.duan.duan.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  账户安全管家
 *
 * */

public class AFragment extends Fragment {
    private List<NewsBean.DataBean.ListBean> list=new ArrayList<>();
    private View view;
    private Dialog dialog;
    private AFragment INSTANCE;
    private int pageNumber=1;
    private int pageSize=5;
    NewsAdapter adapter;
    private AnimationDrawable animationDrawable;
    @BindView(R.id.listview)
    XRecyclerView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StatusBarUtil.setImgTransparent(getActivity());      //这行是让标题沉浸
        view = View.inflate(getActivity(), R.layout.fragment_a, null);
        ButterKnife.bind(this, view);
        INSTANCE=this;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView iv= (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(R.drawable.progress_sao);
        animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();
       // int resource = R.mipmap.gif;
       // Glide.with(this).load(resource).placeholder(resource).into(iv);
       // Glide.with(this).load(resource).into(new GlideDrawableImageViewTarget(iv, 5));
      //  Glide.with(this).load(resource).asGif().placeholder(resource).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
      //  Uri uri = Uri.parse("res://"+getActivity().getPackageName()+"/" + R.mipmap.gif);
       // iv.setImageResource(R.mipmap.gif);
        // getData();
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

    }

    private void setListener() {

    }

    /***
     * 调取接口拿到服务器数据
     * */
    public void getData(){
        dialog= DialogUtil.createLoadingDialog(getActivity(),getString(R.string.loaddings),null);
        dialog.show();
        HttpServiceClient.getInstance().getNews("",pageNumber,pageSize).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                dialog.dismiss();
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        if(response.body().getCode()==200){
                            list = response.body().getData().getList();
                            pageNumber++;
                            pageSize=pageSize+5;
                            setViews();
                            setListener();
                        }else {
                            Toast.makeText(getActivity(), "未知错误", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "解析异常", Toast.LENGTH_SHORT).show();
            }
        });
    }
}