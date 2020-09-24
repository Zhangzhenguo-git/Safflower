package com.pack.safflower.view.navigation.home.tab

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_K
import com.pack.safflower.databinding.RecommendFragmentBinding
import com.pack.safflower.viewmodel.navigation.home.tab.RecommendViewModel

class RecommendFragment : BaseFragment_K() {

    companion object {
        fun newInstance() = RecommendFragment()
    }

    private lateinit var viewModel: RecommendViewModel
    private lateinit var binding: RecommendFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.recommend_fragment,container,false);
        return binding.root
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(RecommendViewModel::class.java)
    }

    override fun initOnClick() {

    }

    override fun initData() {

    }

}