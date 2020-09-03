package com.pack.safflower.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/**
 * @author Zhangzhenguo
 * @create 2020/9/3
 * @Email 18311371235@163.com
 * @Describe
 */
public class JudgeNestedScrollView extends NestedScrollView {

    private boolean isNeedScroll = true;
    private float xDistance, yDistance, xLast, yLast;

    public JudgeNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public JudgeNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public JudgeNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final float x = ev.getX();
        final float y = ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDistance=yDistance=0f;
//                获取按下屏幕时的x和y轴坐标
                xLast=ev.getX();
                yLast=ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
//                获取滑动时停止的x和y轴坐标
                final float curX = ev.getX();
                final float curY = ev.getY();
                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;
                if (xDistance > yDistance) {
                    break;
                }
        }
        return super.onInterceptTouchEvent(ev);

    }

    /**
     * 用来处理NestedScrollView是否拦截滑动事件
     * @param isNeedScroll
     */
    public void setNeedScroll(boolean isNeedScroll) {
        this.isNeedScroll = isNeedScroll;
    }
}
