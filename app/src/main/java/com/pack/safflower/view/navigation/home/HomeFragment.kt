package com.pack.safflower.view.navigation.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pack.banner.IndicatorView
import com.pack.banner.ScaleInTransformer
import com.pack.baselib.UIUtil
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.HomeFragmentBinding
import com.pack.safflower.util.Utils
import com.pack.safflower.view.navigation.home.tab.RecommendFragment
import com.pack.safflower.viewmodel.navigation.home.HomeViewModel


class HomeFragment: BaseFragment_J() {
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
        initBannerView()
        initGridView()
        initRecomment()

    }

    override fun initOnClick() {

    }

    /**
     * banner
     */
    private fun initBannerView() {
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
                }).adapter = HomeViewModel.ImageAdapter(Utils.getImage(6))
    }

    /**
     * 菜单
     */
    private fun initGridView(){
        mViewModel.getGridItems().observe(this, Observer {
            mViewModel.setGridItemAndAdapter(binding.homeGridView,it)
        })
    }

    /**
     * 推荐区域
     */
    private fun initRecomment(){
        Glide.with(mActivity).load(R.mipmap.banner_icon1).apply(RequestOptions().transform(RoundedCorners(10))).into(binding.homeRecommendLeft)
        Glide.with(mActivity).load(R.mipmap.banner_icon2).apply(RequestOptions().transform(RoundedCorners(10))).into(binding.homeRecommendRight)
    }

    /**
     * 页面注销时移除viewpage回调
     */
    override fun onDestroy() {
        mViewModel.unregisterOnPageChangeCallback()
        super.onDestroy()
    }
}