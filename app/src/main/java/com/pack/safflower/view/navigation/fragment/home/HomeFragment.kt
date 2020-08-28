package com.pack.safflower.view.navigation.fragment.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.pack.banner.IndicatorView
import com.pack.banner.ScaleInTransformer
import com.pack.baselib.UIUtil
import com.pack.safflower.util.Utils
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.HomeFragmentBinding
import com.pack.safflower.view.navigation.fragment.home.HomeViewModel.ImageAdapter

class HomeFragment : BaseFragment_J() {
    private lateinit var mViewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

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
    }

    override fun initData() {

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


}