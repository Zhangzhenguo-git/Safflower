package com.pack.safflower.bcr;

import android.app.usage.NetworkStats;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.net.wifi.WifiManager;
import android.os.Parcelable;

import org.jetbrains.annotations.Nullable;

/**
 * @author Zhangzhenguo
 * @create 2020/10/13
 * @Email 18311371235@163.com
 * @Describe
 */
public class CheckNetWorkBcr extends BroadcastReceiver {

    public static final int NETSTATUS_INAVAILABLE = 0;
    public static final int NETSTATUS_WIFI = 1;
    public static final int NETSTATUS_MOBILE = 2;
    private static int netStatus = 0;
    private NetWorkStatusListener mNetWorkStatusListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileNetInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNetInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo allNetInfo = manager.getActiveNetworkInfo();
        if (manager!=null){
            if (allNetInfo ==null){
                if (mobileNetInfo!=null && mobileNetInfo.isConnected() ||mobileNetInfo.isConnectedOrConnecting()){
                    netStatus = NETSTATUS_MOBILE;
                }else if (wifiNetInfo!=null && wifiNetInfo.isConnected() ||wifiNetInfo.isConnectedOrConnecting()){
                    netStatus = NETSTATUS_WIFI;
                }else{
                    netStatus = NETSTATUS_INAVAILABLE;
                }
            }else {
                if (allNetInfo.isConnected() || allNetInfo.isConnectedOrConnecting()) {
                    if (mobileNetInfo.isConnected() || mobileNetInfo.isConnectedOrConnecting()) {
                        netStatus = NETSTATUS_MOBILE;
                    } else {
                        netStatus = NETSTATUS_WIFI;
                    }
                } else {
                    netStatus = NETSTATUS_INAVAILABLE;
                }
            }
            if(mNetWorkStatusListener != null){
                mNetWorkStatusListener.getNetWorkState(netStatus);
            }
//            switch (intent.getAction()) {
//                case WifiManager.WIFI_STATE_CHANGED_ACTION:
//                    int wifiState=intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,0);
//                    switch (wifiState){
////                    当前已禁用
//                        case WifiManager.WIFI_STATE_DISABLED:
//                            System.out.println("111-WIFI_STATE_DISABLED");
//                            break;
////                    当前已启用
//                        case WifiManager.WIFI_STATE_ENABLED:
//                            System.out.println("111-WIFI_STATE_ENABLED");
//
//                            break;
//                    }
//                    break;
//                case WifiManager.NETWORK_STATE_CHANGED_ACTION:
//                    System.out.println("111-网络正在发生变化时调用--基本这个不使用");
//                    break;
//                case ConnectivityManager.CONNECTIVITY_ACTION:
//                    System.out.println("111-网络连接上或断开时调用");
//                    break;
//            }
        }
    }
    public void setNetStateListener(NetWorkStatusListener listener){
        mNetWorkStatusListener = listener;
    }

    public interface NetWorkStatusListener{
        void getNetWorkState(int state);
    }
}
