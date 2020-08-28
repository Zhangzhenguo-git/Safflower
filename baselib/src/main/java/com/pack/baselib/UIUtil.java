package com.pack.baselib;

import android.content.Context;

/**
 * @author Zhangzhenguo
 * @create 2020/8/27
 * @Email 18311371235@163.com
 * @Describe
 */
public class UIUtil {
    public static int dip2px(Context context, double dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
