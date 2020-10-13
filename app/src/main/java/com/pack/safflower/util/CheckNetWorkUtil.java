package com.pack.safflower.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * @author Zhangzhenguo
 * @create 2020/10/13
 * @Email 18311371235@163.com
 * @Describe
 */
public class CheckNetWorkUtil {
    /**
     * 没有连接网络
     */
    private static final int NETWORK_NONE = -1;
    /**
     * 移动网络
     */
    private static final int NETWORK_MOBILE = 0;
    /**
     * 无线网络
     */
    private static final int NETWORK_WIFI = 1;

    /**
     * 无线网络
     */
    private static final int TRANSPORT_WIFI = 2;
    /**
     * 蜂窝
     */
    private static final int TRANSPORT_CELLULAR = 3;
    /**
     * 以太网
     */
    private static final int TRANSPORT_ETHERNET = 4;


    /**
     * 检查网络情况
     * @param context
     * @return
     */
    public int checkNetWork(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager!=null){
            NetworkInfo info=manager.getActiveNetworkInfo();
            if (info!=null && info.isConnected()){
                if (info.getType()==ConnectivityManager.TYPE_WIFI){
                    return NETWORK_WIFI;
                }else if (info.getType()==ConnectivityManager.TYPE_MOBILE){
                    return NETWORK_MOBILE;
                }
            }
        }
        return NETWORK_NONE;
    }

    /**
     * 检查网络情况
     * @param context
     * @return
     */
    public int checkNetWorkOfWifi(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager!=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities networkCapabilities=manager.getNetworkCapabilities(manager.getActiveNetwork());
                if (networkCapabilities!=null){
                    if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                        return TRANSPORT_WIFI;
                    }else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                        return TRANSPORT_CELLULAR;
                    }else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)){
                        return TRANSPORT_ETHERNET;
                    }
                }
            }else {
                NetworkInfo info=manager.getActiveNetworkInfo();
                if (info!=null){
                    if (info.getType()==ConnectivityManager.TYPE_WIFI){
                        return NETWORK_WIFI;
                    }else if (info.getType()==ConnectivityManager.TYPE_MOBILE){
                        return NETWORK_MOBILE;
                    }
                }
            }
        }
        return NETWORK_NONE;
    }
}
