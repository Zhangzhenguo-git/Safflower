package com.pack.safflower.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pack.safflower.view_viewmodel.navigation.fragment.home.HomeViewModel;

/**
 * @author Zhangzhenguo
 * @create 2020/8/27
 * @Email 18311371235@163.com
 * @Describe
 */
public abstract class BaseFragment_J extends Fragment {
    public Activity mActivity;
    public String TAG="";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity=this.getActivity();
        TAG=mActivity.getPackageName();
        initViewModel();
        initData();
        initOnClick();
    }

    protected abstract void initViewModel();
    protected abstract void initData();
    protected abstract void initOnClick();

    /**
     * @param context 当前上下文
     * @param endClass 跳转到的activity
     * @param requestCode 请求code，可以根据实际情况填写
     * 全局跳转
     */
    protected void baseStartActivity(Activity context,Class<Activity> endClass,int requestCode){
        Intent intent= new Intent(context,endClass);
        if (requestCode==-1){
            startActivity(intent);
            context.finish();
        }else{
            startActivityForResult(intent,requestCode);
        }
    }

    /**
     * 检测网络变化
     * @return
     */
    protected boolean checkNetworkOrWifi(){
        boolean isTrue=false;
        ConnectivityManager manager = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ( networkInfo != null && networkInfo.isConnected() ) {
            return isTrue=true;
        }
        return isTrue;

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
