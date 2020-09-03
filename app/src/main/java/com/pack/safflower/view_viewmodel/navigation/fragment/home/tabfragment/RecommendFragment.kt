package com.pack.safflower.view_viewmodel.navigation.fragment.home.tabfragment

import android.database.DatabaseUtils
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.RecommendFragmentBinding

class RecommendFragment : BaseFragment_J() {

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