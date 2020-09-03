package com.pack.jetpack.livedata;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.pack.jetpack.R;
import com.pack.jetpack.databinding.ActivityLiveDataBinding;


public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding binding;
    private LiveDataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);
        viewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
//        设置ViewModel
        binding.setLiveData(viewModel);
//        添加生命周期的观测
        binding.setLifecycleOwner(this);
//        viewModel.getTicePlus().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                System.out.println(viewModel.getTicePlus().getValue());
//                binding.textView3.setText(String.valueOf(viewModel.getTicePlus().getValue()));
//            }
//        });
//        viewModel.getTickReduce().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                System.out.println(viewModel.getTickReduce().getValue());
//                binding.textView4.setText(String.valueOf(viewModel.getTickReduce().getValue()));
//            }
//        });
//        myClick();
    }

    private void myClick() {
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.plusTick();
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.reduceTick();
            }
        });
    }
}