package com.pack.safflower.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @author Zhangzhenguo
 * @create 2020/8/27
 * @Email 18311371235@163.com
 * @Describe
 */
abstract class BaseFragment_K:Fragment(){

    lateinit var mActivity:Activity
    protected var TAG:String=""
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mActivity= this.requireActivity()
        TAG=mActivity.packageName
        initViewModel();
        initData();
        initOnClick();
        // TODO: Use the ViewModel
    }

    abstract fun initViewModel();
    abstract fun initData();
    abstract fun initOnClick();
    /**
     * @param context 当前上下文
     * @param endClass 跳转到的activity
     * @param requestCode 请求code，可以根据实际情况填写
     * 全局跳转
     */
    fun baseStartActivity(context: Activity, endClass:Class<Activity>, requestCode:Int){
        var intent: Intent = Intent(context,endClass)
        if (requestCode==-1){
            startActivity(intent)
            context.finish()
        }else{
            startActivityForResult(intent,requestCode)
        }
    }
    /**
     * 检测网络变化
     * @return
     */
    fun checkNetworkOrWifi(): Boolean {
        var isTrue = false
        val manager = mActivity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val wifiNetwork = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (networkInfo != null && networkInfo.isConnected  && wifiNetwork!!.isConnected) {
            isTrue=true
        } else{
            isTrue=false
        }
        return isTrue
    }
}