package com.pack.safflower.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pack.safflower.R

/**
 * @author Zhangzhenguo
 * @create 2020/9/2
 * @Email 18311371235@163.com
 * @Describe
 */
class TabPageAdapter: RecyclerView.Adapter<TabPageAdapter.CardViewHolder>() {

    var mActivity:Activity=Activity()
    var pagerS:List<Fragment> = arrayListOf()


    fun TabPageAdapter(mActivity:Activity,pagerS:List<Fragment>){
        this.mActivity=mActivity
        this.pagerS=pagerS
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(CardView(LayoutInflater.from(parent.context),parent))
    }

    override fun getItemCount(): Int {
        return pagerS.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        pagerS[position]
    }

    //internal 相当于私有化，只在当前类中使用、constructor相当于主构造函数，用来定义类的主构造方法且只能有一个
    class CardViewHolder internal constructor(private val cardView:CardView):RecyclerView.ViewHolder(cardView.view){

    }


    class CardView(layoutInflater: LayoutInflater, container:ViewGroup?){
        val view:View=layoutInflater.inflate(R.layout.recommend_fragment,container,false)
        private val recommendFrag : TextView
        init {
            recommendFrag = view.findViewById(R.id.recommendFrag)
        }

    }
}