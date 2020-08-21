package com.pack.jetpack.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pack.jetpack.R;
import com.pack.jetpack.databinding.WorksFragmentBinding;


public class WorksFragment extends Fragment {

    private WorksViewModel mViewModel;
    private WorksFragmentBinding binding;
    private NavController controller;
    public static WorksFragment newInstance() {
        return new WorksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//         inflater.inflate(R.layout.works_fragment, container, false);
        binding=WorksFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(WorksViewModel.class);
        mViewModel.initWorksViewModel(getActivity());
        binding.setWorksLiveData(mViewModel);
//        设置观察者模式
//        binding.setLifecycleOwner(this);
        // TODO: Use the ViewModel
        controller= Navigation.findNavController(getView());
        binding.btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_worksFragment_to_addFragment);
            }
        });
        binding.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvWorksShow.setText(mViewModel.searchWorksData());
            }
        });
        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvWorksShow.setText(mViewModel.deleteWorksData());
            }
        });
        binding.btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvWorksShow.setText(mViewModel.updateWorksData());
            }
        });
    }

}