package com.example.duan.duan.DCZ_selft;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.duan.duan.R;


/**
 * Created by enjoytouch-ad02 on 2015/8/5.
 */
public class MiddleDialog<E> extends Dialog {
    private onButtonCLickListener listener;
    private onButtonCLickListener2 listener2;
    private onOKListeners okListeners;
    private onUpdateListeners listeners3;
    private E bean;
    private int position;
    private View view;

    public MiddleDialog(Context context, String title, final onButtonCLickListener2<E> listener, int theme) {
        super(context, theme);
        if(title.equals("动态密码")){
            view = View.inflate(context, R.layout.dialog2_middle, null);
            view.findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }else {
            view = View.inflate(context, R.layout.dialog_middle, null);
        }
        setContentView(view);
        setCancelable(true);        //设置点击对话框以外的区域时，是否结束对话框
        ((TextView) view.findViewById(R.id.middle_tv)).setText(title);       //设置对话框的标题内容
        this.listener2 = listener;
        view.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    /*    view.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {      //确定
            @Override
            public void onClick(View v) {
                //if(bean!=null){
                dismiss();
                listener2.onActivieButtonClick(bean, position);
                // }
            }
        });*/
    }

    public interface onOKListeners{
        void onOkButton();
    }

    public interface onUpdateListeners{
        void onButton(String password);
    }

    public interface onButtonCLickListener{
       public void onButtonCancel();
       public void onButtonOK(String value);
    }
    public interface onButtonCLickListener2<E>{
        public void onActivieButtonClick(E bean, int position);
    }
    public void resetData(E bean,int position) {
        this.bean=bean;
        this.position = position;
    }
}
