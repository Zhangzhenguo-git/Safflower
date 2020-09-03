package com.pack.safflower.model.home.impl

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

}