package com.pack.safflower.base

import android.app.Activity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * @author Zhangzhenguo
 * @create 2020/9/1
 * @Email 18311371235@163.com
 * @Describe
 */
abstract class BaseViewModel:ViewModel(){
    var mActivity: Activity = Activity();
    /**
     * 设置当前上下文
     */
    fun setContext(activity: Activity){
        this.mActivity=activity
    }

}