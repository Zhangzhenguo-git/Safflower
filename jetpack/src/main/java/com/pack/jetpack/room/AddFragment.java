package com.pack.jetpack.room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pack.jetpack.R;
import com.pack.jetpack.databinding.AddFragmentBinding;


public class AddFragment extends Fragment {

    private AddViewModel mViewModel;
    private AddFragmentBinding binding;
    private NavController controller;

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.add_fragment, container, false);
        binding= AddFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        mViewModel.initAddViewModel(getActivity());
        binding.setAddViewModel(mViewModel);
        // TODO: Use the ViewModel
        controller= Navigation.findNavController(getView());
        binding.btAddDataDaoWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.etWorks.getText().toString().trim()) || TextUtils.isEmpty(binding.etName.getText().toString().trim())){
                    Toast.makeText(getActivity(), "请输入完整信息", Toast.LENGTH_SHORT).show();
                    return;
                }
//                添加数据
                mViewModel.insert(binding.etName.getText().toString().trim(),binding.etWorks.getText().toString().trim());
                controller.navigate(R.id.action_addFragment_to_worksFragment);
            }
        });
    }


}