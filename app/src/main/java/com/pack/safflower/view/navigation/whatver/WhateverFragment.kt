package com.pack.safflower.view.navigation.whatver

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.WhateverFragmentBinding
import com.pack.safflower.viewmodel.navigation.whatver.WhateverViewModel

class WhateverFragment : BaseFragment_J() {
    private lateinit var binding: WhateverFragmentBinding

    private lateinit var viewModel: WhateverViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.whatever_fragment, container, false);

        return binding.root
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(WhateverViewModel::class.java)
    }

    override fun initData() {
    }

    override fun initOnClick() {
    }

}