package com.pack.statelayout;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.pack.statelayout.databinding.RlayoutEmptyBinding;
import com.pack.statelayout.databinding.RlayoutErrorBinding;
import com.pack.statelayout.databinding.RlayoutFailBinding;
import com.pack.statelayout.databinding.RlayoutLoadingBinding;

/**
 * @author Zhangzhenguo
 * @create 2020/8/21
 * @Email 18311371235@163.com
 * @Describe
 */
public class StateLayoutView extends RelativeLayout{
    private Context mContext;
    //默认，不显示任何的View
    private final int NORMAL = 0;
    //加载中
    private final int LOADING = 1;
    //加载失败
    private final int LOADFAIL = 2;
    //加载错误
    private final int LOADERROR = 3;
    //内容为空
    private final int LOADEMPTY = 4;

    private LayoutInflater mInflater;

    public StateLayoutView(Context context) {
        super(context);
        this.mContext=context;
        init();
    }

    public StateLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        init();
    }

    public StateLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        init();
    }

    private void init(){
        mInflater=LayoutInflater.from(mContext);
    }

    public class Builder{
        private RlayoutLoadingBinding loadingBinding;
        private RlayoutFailBinding failBinding;
        private RlayoutErrorBinding errorBinding;
        private RlayoutEmptyBinding emptyBinding;
        public Builder Builder(){
            return this;
        }

        /**
         *加载中
         */
        private void setrLayoutLoadIng(){
            if (loadingBinding==null){
                View contentView=mInflater.inflate(R.layout.rlayout_loading,null);
                loadingBinding= DataBindingUtil.bind(contentView);
                addView(contentView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                loadingBinding.btIng.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideLoadIng();
                    }
                });
            }else {
                loadingBinding.loadIng.setVisibility(VISIBLE);
            }
        }

        /**
         * 加载失败
         */
        private void setrLayoutLoadFail(){
            if (failBinding==null){
                View contentView=mInflater.inflate(R.layout.rlayout_fail,null);
                failBinding= DataBindingUtil.bind(contentView);
                addView(contentView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                failBinding.btFail.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideLoadFail();
                    }
                });
            }else {
                failBinding.fail.setVisibility(VISIBLE);
            }
        }
        /**
         * 加载错误
         */
        private void setrLayoutLoadError(){
            if (errorBinding==null){
                View contentView=mInflater.inflate(R.layout.rlayout_error,null);
                errorBinding=DataBindingUtil.bind(contentView);
                addView(contentView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                errorBinding.btError.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideLoadError();
                    }
                });
            }else {
                errorBinding.error.setVisibility(VISIBLE);
            }
        }
        /**
         * 加载空数据
         */
        private void setrLayoutLoadEmpty(){
            if (emptyBinding==null){
                View contentView=mInflater.inflate(R.layout.rlayout_empty,null);
                emptyBinding=DataBindingUtil.bind(contentView);
                addView(contentView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                emptyBinding.btEmpty.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideLoadEmpty();
                    }
                });
            }else {
                emptyBinding.empty.setVisibility(VISIBLE);
            }
        }
        /**
         * 隐藏加载框
         */
        private void hideLoadIng(){
            if (loadingBinding!=null)
            if (loadingBinding.loadIng != null){
                loadingBinding.loadIng.setVisibility(GONE);
            }
        }

        /**
         * 隐藏加载失败
         */
        private void hideLoadFail(){
            if (failBinding!=null)
            if (failBinding.fail != null){
                failBinding.fail.setVisibility(GONE);
            }
        }
        /**
         * 隐藏加载错误
         */
        private void hideLoadError(){
            if (errorBinding!=null)
            if (errorBinding.error != null){
                errorBinding.error.setVisibility(GONE);
            }
        }
        /**
         * 隐藏加载到空数据
         */
        private void hideLoadEmpty(){
            if (emptyBinding!=null)
            if (emptyBinding.empty != null){
                emptyBinding.empty.setVisibility(GONE);
            }
        }

        /**
         * 正常加载框
         * @param arg0 图片
         * @param arg1 提示语
         * @param arg2 按钮
         * @return
         */
        public Builder setIngImgOrTitleOrBt(int arg0,String arg1,String arg2){
            if (!TextUtils.isEmpty(arg0+"")){
            }
            if (!TextUtils.isEmpty(arg1)){
                loadingBinding.loadingTitle.setText(arg1);
            }
            if (!TextUtils.isEmpty(arg2)){
                loadingBinding.btIng.setText(arg2);
            }
            return this;
        }
        /**
         * 加载错误
         * @param arg0 图片
         * @param arg1 提示语
         * @param arg2 按钮
         * @return
         */
        public Builder setFailImgOrTitleOrBt(int arg0,String arg1,String arg2){
            if (!TextUtils.isEmpty(arg0+"")){
            }
            if (!TextUtils.isEmpty(arg1)){
                failBinding.failTitle.setText(arg1);
            }
            if (!TextUtils.isEmpty(arg2)){
                failBinding.btFail.setText(arg2);
            }
            return this;
        }
        /**
         * 加载失败
         * @param arg0 图片
         * @param arg1 提示语
         * @param arg2 按钮
         * @return
         */
        public Builder setErrorImgOrTitleOrBt(int arg0,String arg1,String arg2){
            if (!TextUtils.isEmpty(arg0+"")){
            }
            if (!TextUtils.isEmpty(arg1)){
                errorBinding.errorTitle.setText(arg1);
            }
            if (!TextUtils.isEmpty(arg2)){
                errorBinding.btError.setText(arg2);
            }
            return this;
        }
        /**
         * 加载到空数据
         * @param arg0 图片
         * @param arg1 提示语
         * @param arg2 按钮
         * @return
         */
        public Builder setEmptyImgOrTitleOrBt(int arg0,String arg1,String arg2){
            if (!TextUtils.isEmpty(arg0+"")){
            }
            if (!TextUtils.isEmpty(arg1)){
                emptyBinding.emptyTitle.setText(arg1);
            }
            if (!TextUtils.isEmpty(arg2)){
                emptyBinding.btEmpty.setText(arg2);
            }
            return this;
        }
        /**
         * 显示加载框
         */
        public Builder showLoadIng(){
            setState(LOADING);
            return this;
        }

        /**
         * 显示加载失败
         */
        public Builder showLoadFail(){
            setState(LOADFAIL);
            return this;
        }
        /**
         * 显示加载错误
         */
        public Builder showLoadError(){
            setState(LOADERROR);
            return this;
        }
        /**
         * 显示加载到空数据
         */
        public Builder showLoadEmpty(){
            setState(LOADEMPTY);
            return this;
        }
        /**
         * 显示加载正常模式
         */
        public Builder hideAllState(){
            setState(NORMAL);
            return this;
        }

        /**
         * 状态判断并设置显示或隐藏
         * @param state
         */
        private void setState(int state) {
            switch (state) {
                case NORMAL:
                    hideLoadIng();
                    hideLoadFail();
                    hideLoadError();
                    hideLoadEmpty();
                    break;
                case LOADING:
                    setrLayoutLoadIng();
                    hideLoadFail();
                    hideLoadError();
                    hideLoadEmpty();
                    break;
                case LOADFAIL:
                    hideLoadIng();
                    setrLayoutLoadFail();
                    hideLoadError();
                    hideLoadEmpty();
                    break;
                case LOADERROR:
                    hideLoadIng();
                    hideLoadFail();
                    setrLayoutLoadError();
                    hideLoadEmpty();
                    break;
                case LOADEMPTY:
                    hideLoadIng();
                    hideLoadFail();
                    hideLoadError();
                    setrLayoutLoadEmpty();
                    break;
                default:
                    hideLoadIng();
                    hideLoadFail();
                    hideLoadError();
                    hideLoadEmpty();
                    break;
            }
        }
    }
}
