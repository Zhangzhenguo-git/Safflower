package com.pack.safflower.view_viewmodel.navigation.fragment.home

import android.R.id.tabs
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.pack.banner.IndicatorView
import com.pack.banner.ScaleInTransformer
import com.pack.baselib.UIUtil
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.HomeFragmentBinding
import com.pack.safflower.util.Utils
import com.pack.safflower.view_viewmodel.navigation.fragment.home.HomeViewModel.ImageAdapter
import com.pack.safflower.view_viewmodel.navigation.fragment.home.tabfragment.RecommendFragment


class HomeFragment:BaseFragment_J() {
    private lateinit var mViewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private var pagerS:MutableList<Fragment> = ArrayList()
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.getRoot()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.liveData=mViewModel
        mViewModel.setContext(mActivity);
    }

    override fun initData() {
        pagerS.add(RecommendFragment())
        pagerS.add(RecommendFragment())
        pagerS.add(RecommendFragment())
        pagerS.add(RecommendFragment())
        pagerS.add(RecommendFragment())
        pagerS.add(RecommendFragment())
        mViewModel.getTabItems().observe(this, Observer {
            if (it!=null && it.size>0){
                mViewModel.setTabItem(binding.homeTable,it)
                mViewModel.setTabPageAdapter(binding.homeTabViewPage,pagerS,it, requireActivity().supportFragmentManager,lifecycle)
            }
        })

    }

    override fun initOnClick() {
        initBannerView()

    }

    /**
     * 实例化banner轮播
     */
    private fun initBannerView() {
        binding!!.homeBannerView.setAutoTurningTime(3000)
                .setIndicator(IndicatorView(mActivity)
                        .setIndicatorColor(Color.WHITE)
                        .setIndicatorStyle(IndicatorView.IndicatorStyle.INDICATOR_CIRCLE_RECT)
                        .setIndicatorSelectorColor(Color.BLACK)
                )
                .setPageMargin(UIUtil.dip2px(mActivity, 20.0), UIUtil.dip2px(mActivity, 10.0))
//                轮播两边样式
                .addPageTransformer(ScaleInTransformer())
                .setOuterPageChangeListener(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        Log.e(TAG, "initBanner2 onPageSelected $position")
                    }
                }).adapter = ImageAdapter(Utils.getImage(6))
    }

    /**
     * 页面显示时加载当前页面状态
     */
     override fun onResume() {
         super.onResume()
//         if (!checkNetworkOrWifi()){
//             binding.homeState.Builder()
//                     .showLoadFail()
//                     .setFailImgOrTitleOrBt(1,"网络连接已断开，请检查网络哦","去开启")
//         }
     }

    /**
     * 页面注销时移除viewpage回调
     */
    override fun onDestroy() {
        mViewModel.unregisterOnPageChangeCallback()
        super.onDestroy()
    }
}