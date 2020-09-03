package com.pack.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.pack.jetpack.databinding.ActivityMainBinding;
import com.pack.jetpack.livedata.LiveDataActivity;
import com.pack.jetpack.navdemo.NavigationActivity;
import com.pack.jetpack.paging.PagingActivity;
import com.pack.jetpack.room.RoomActivity;
import com.pack.jetpack.viewmodeldemo.TestViewModelActivity;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myCLick();
    }

    private void myCLick() {
        binding.btViewModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestViewModelActivity.class));
            }
        });
        binding.btLiveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
            }
        });
        binding.btNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            }
        });
        binding.btRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });
        binding.btLifecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifeActivity.class));
            }
        });
        binding.btPaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagingActivity.class));
            }
        });
    }
}