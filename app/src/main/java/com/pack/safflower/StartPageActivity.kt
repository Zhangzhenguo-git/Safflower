package com.pack.safflower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.pack.safflower.base.BaseActivity_K
import com.pack.safflower.databinding.ActivityStartPageBinding

class StartPageActivity : BaseActivity_K() {
    lateinit var binding:ActivityStartPageBinding
    lateinit var startPageHandler:Handler
    lateinit var runnable: Runnable
    override fun setContentView(){
        binding=DataBindingUtil.setContentView(this,R.layout.activity_start_page)
    }

    override fun initData() {
        startPageHandler=object :Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                baseStartActivity(this@StartPageActivity,MainActivity().javaClass,0)
            }
        }
        runnable= object:Runnable {
            override fun run() {
                baseStartActivity(this@StartPageActivity,MainActivity().javaClass,0)
            }
        }
    }


    override fun initClick() {
//        startPageHandler.postDelayed(runnable,3000)
        startPageHandler.sendEmptyMessageDelayed(0,3000)
    }
}