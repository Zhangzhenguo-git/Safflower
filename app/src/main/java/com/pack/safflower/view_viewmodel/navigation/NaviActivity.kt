package com.pack.safflower.view_viewmodel.navigation

import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.pack.safflower.R
import com.pack.safflower.base.BaseActivity_K
import com.pack.safflower.databinding.ActivityNaviBinding

class NaviActivity : BaseActivity_K() {
    lateinit var binding: ActivityNaviBinding

    override fun setContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navi)
    }

    override fun initData() {
        initNavigation()
    }

    override fun initClick() {

    }

    override fun onResume() {
        super.onResume()
        println("执行navi1")
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        println("执行navi2")
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
}