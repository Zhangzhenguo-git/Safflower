package com.pack.safflower.view_viewmodel.navigation.fragment.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.pack.safflower.R
import com.pack.safflower.base.BaseFragment_K
import com.pack.safflower.databinding.ReadFragmentBinding

class ReadFragment : BaseFragment_K() {
    private lateinit var mViewModel: ReadViewModel
    private lateinit var binding: ReadFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.read_fragment, container, false)
        return binding.getRoot()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ReadViewModel::class.java)
    }

    override fun initData() {}
    override fun initOnClick() {}

    companion object {
        fun newInstance(): ReadFragment {
            return ReadFragment()
        }
    }
}