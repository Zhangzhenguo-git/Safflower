package com.pack.banner;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Px;

/**
 * @author Zhangzhenguo
 * @create 2020/8/27
 * @Email 18311371235@163.com
 * @Describe
 */
public interface Indicator {
    /**
     *数据初始化完成后回调
     * @param pagerCount page num
     */
    void initIndicatorCount(int pagerCount);

    /**
     * 返回当前的iew
     */
    View getView();

    /**
     * 返回当前的layoutparams的布局
     */
    RelativeLayout.LayoutParams getParams();

    /**
     * 重新定义当前指示器的回调
     * 当滚动当前页面时（作为程序启动的平滑滚动的一部分*或由用户启动的触摸滚动的一部分），将调用此方法。
     * @param position 当前显示的第一页的位置索引。 *如果positionOffset不为零，则页面position + 1将可见。
     * @param positionOffset  [0，1）中的值表示与位置页面的偏移量。
     * @param positionOffsetPixels 以像素为单位的值，指示与位置的偏移量。
     */
    void onPageScrolled(int position, float positionOffset, @Px int positionOffsetPixels);

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    void onPageSelected(int position);

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see androidx.viewpager2.widget.ViewPager2#SCROLL_STATE_IDLE
     * @see androidx.viewpager2.widget.ViewPager2#SCROLL_STATE_DRAGGING
     * @see androidx.viewpager2.widget.ViewPager2#SCROLL_STATE_SETTLING
     */
    void onPageScrollStateChanged(int state);
}
