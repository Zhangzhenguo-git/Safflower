package com.pack.safflower.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingMethods
import androidx.databinding.ViewDataBinding

/**
 * @author Zhangzhenguo
 * @create 2020/8/21
 * @Email 18311371235@163.com
 * @Describe
 */
abstract class BaseActivity_K: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView()
        initData()
        initClick()
    }

    /**
     * 实例化ViewId
     */
    abstract fun setContentView()

    /**
     * 实例化数据
     */
    abstract fun initData()

    /**
     * 事件分发
     */
    abstract fun initClick()

    /**
     * @param context 当前上下文
     * @param endClass 跳转到的activity
     * @param requestCode 请求code，可以根据实际情况填写
     * 全局跳转
     */
    fun baseStartActivity(context:Activity,endClass:Class<Activity>,requestCode:Int){
        var intent: Intent= Intent(context,endClass)
        if (requestCode==-1){
            startActivity(intent)
            context.finish()
        }else{
            startActivityForResult(intent,requestCode)
        }

    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //修改背景为白色
        window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
    }
}