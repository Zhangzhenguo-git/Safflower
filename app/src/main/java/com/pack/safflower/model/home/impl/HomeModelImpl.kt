package com.pack.safflower.model.home.impl

import com.pack.safflower.R
import com.pack.safflower.model.home.GridData
import com.pack.safflower.model.home.HomeModel
import com.pack.safflower.model.home.TableData

/**
 * @author Zhangzhenguo
 * @create 2020/8/31
 * @Email 18311371235@163.com
 * @Describe
 */ class HomeModelImpl : HomeModel {

    var people2 = listOf(
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐")
    )

    /**
     * 获取tab选项卡Item内容
     */
    override fun getTabItems(): List<TableData> {
//        ...省略网络请求
        return people2
    }


    var gridS= listOf(
            GridData(R.mipmap.ic_launcher,"菜单1"),
            GridData(R.mipmap.ic_launcher,"菜单2"),
            GridData(R.mipmap.ic_launcher,"菜单3"),
            GridData(R.mipmap.ic_launcher,"菜单4"),
            GridData(R.mipmap.ic_launcher,"菜单5"),
            GridData(R.mipmap.ic_launcher,"菜单6"),
            GridData(R.mipmap.ic_launcher,"菜单7"),
            GridData(R.mipmap.ic_launcher,"菜单8"),
            GridData(R.mipmap.ic_launcher,"菜单9"),
            GridData(R.mipmap.ic_launcher,"敬请期待")
    )
    /**
     * 获取网格菜单Item内容
     */
    override fun getGridItems(): List<GridData> {
//        ...省略网络请求
        return gridS
    }

}