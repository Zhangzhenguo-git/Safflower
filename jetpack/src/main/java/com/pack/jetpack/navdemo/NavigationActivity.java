package com.pack.jetpack.navdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pack.jetpack.R;
import com.pack.jetpack.databinding.ActivityNavigationBinding;


public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        initNavigation();
    }
    private void initNavigation(){
        NavController controller=Navigation.findNavController(this,R.id.fragment2);
        AppBarConfiguration configuration=new AppBarConfiguration.Builder(binding.bottomNavigationView3.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,controller,configuration);
//        当目标更改时，选中目标将自动更新
        NavigationUI.setupWithNavController(binding.bottomNavigationView3,controller);
    }
    private void myClick(){

    }
}