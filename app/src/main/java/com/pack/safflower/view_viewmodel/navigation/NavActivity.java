package com.pack.safflower.view_viewmodel.navigation;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pack.safflower.R;
import com.pack.safflower.base.BaseActivity_K;
import com.pack.safflower.databinding.ActivityNavBinding;

public class NavActivity extends BaseActivity_K {

    private ActivityNavBinding binding;
    @Override
    public void setContentView() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_nav);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initClick() {

    }
    private void sss(){
        NavController navController= Navigation.findNavController(this,R.id.naviFragment);

        AppBarConfiguration configuration=new AppBarConfiguration.Builder(binding.naviBottomNavigation.getMenu()).build();

        NavigationUI.setupActionBarWithNavController(this,navController,configuration);

        NavigationUI.setupWithNavController(binding.naviBottomNavigation,navController);

    }
}