package com.pack.statelayout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author Zhangzhenguo
 * @create 2020/8/21
 * @Email 18311371235@163.com
 * @Describe
 */
class StateLayoutView extends RelativeLayout {
    private Context mContext;
//    显示布局类型，默认值为0常规状态、1加载中状态、2加载失败状态、3、加载错误、4、加载数据为空
    private int LAYOUTCODE=0;
    private RelativeLayout rLayoutLoadIng,rLayoutLoadFin,rLayoutLoadError,rLayoutLoadEmpty;
    private LayoutInflater mInflater;
//    布局ID
    private int mLayoutID;

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

    /**
     * 设置布局
     * @param layoutID
     */
    public void setLayout(int layoutID){
        this.mLayoutID=layoutID;
    }

    private void setrLayoutLoadIng(){
        if (rLayoutLoadIng==null){
            View contentView=mInflater.inflate(R.layout.rlayout_loading,this);
        }
    }


}
