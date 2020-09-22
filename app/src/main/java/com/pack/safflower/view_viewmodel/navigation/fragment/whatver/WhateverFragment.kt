package com.pack.safflower.view_viewmodel.navigation.fragment.whatver

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_K

class WhateverFragment : BaseFragment_K() {

    companion object {
        fun newInstance() = WhateverFragment()
    }

    private lateinit var viewModel: WhateverViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.whatever_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WhateverViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initOnClick() {
        TODO("Not yet implemented")
    }

}