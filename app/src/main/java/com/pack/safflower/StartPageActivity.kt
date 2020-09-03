package com.pack.safflower

import android.os.Handler
import android.os.Message
import androidx.databinding.DataBindingUtil
import com.pack.safflower.base.BaseActivity_K
import com.pack.safflower.databinding.ActivityStartPageBinding
import com.pack.safflower.view_viewmodel.navigation.NaviActivity

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
                baseStartActivity(this@StartPageActivity,NaviActivity().javaClass,-1)
            }
        }
        runnable= object:Runnable {
            override fun run() {
                baseStartActivity(this@StartPageActivity,NaviActivity().javaClass,-1)
            }
        }
    }


    override fun initClick() {
//        startPageHandler.postDelayed(runnable,3000)
        startPageHandler.sendEmptyMessageDelayed(0,500)
    }
}