package com.pack.safflower.view.navigation

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.pack.safflower.R
import com.pack.safflower.base.BaseActivity_K
import com.pack.safflower.bcr.CheckNetWorkBcr
import com.pack.safflower.databinding.ActivityNaviBinding

class NaviActivity : BaseActivity_K() {
    lateinit var binding: ActivityNaviBinding
    lateinit var checkNetWorkBcr:CheckNetWorkBcr
    override fun setContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navi)
        openNetWorkBroadcast()
    }

    override fun initData() {
        initNavigation()
    }

    override fun initClick() {

    }

    /**
     * 注册检测网络广播
     */
    fun openNetWorkBroadcast(){
        checkNetWorkBcr= CheckNetWorkBcr()
        val filter = IntentFilter()
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(checkNetWorkBcr, filter)
    }
    /**
     * 页面显示时加载当前页面状态
     */
    override fun onResume() {
        super.onResume()
        System.out.println("执行home")
        checkNetWork()

    }

    /**
     * 底部导航栏
     */
    fun initNavigation() {
//        相当于实例化一个fragment容器
        val navController: NavController = Navigation.findNavController(this, R.id.naviFragment)
//        相当于实例化底部导航组件
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(binding.naviBottomNavigation.getMenu()).build()
        NavigationUI.setupActionBarWithNavController(this, navController, configuration)
//        当选中目标更改时，其它自动切换状态
        NavigationUI.setupWithNavController(binding.naviBottomNavigation, navController)
    }

    /**
     * 实时监测网络回调
     */
    fun checkNetWork() {
        checkNetWorkBcr.setNetStateListener {
            if (it == CheckNetWorkBcr.NETSTATUS_WIFI) {
                binding.homeState.Builder().hideAllState()
            } else if (it == CheckNetWorkBcr.NETSTATUS_MOBILE) {
                binding.homeState.Builder().hideAllState()
            } else {
                binding.homeState.Builder()
                        .showLoadFail()
                        .setFailImgOrTitleOrBt(1, "网络连接已断开，请检查网络哦", "去开启")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(checkNetWorkBcr);
    }
}

