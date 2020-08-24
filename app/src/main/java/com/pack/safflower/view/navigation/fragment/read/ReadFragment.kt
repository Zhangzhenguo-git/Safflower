package com.pack.safflower.view.navigation.fragment.read

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pack.safflower.R

class ReadFragment : Fragment() {

    companion object {
        fun newInstance() = ReadFragment()
    }

    private lateinit var viewModel: ReadViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.read_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReadViewModel::class.java)
        // TODO: Use the ViewModel
    }

}