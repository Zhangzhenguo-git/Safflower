package com.pack.jetpack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pack.jetpack.view.ChronometerTimer;


public class LifeActivity extends AppCompatActivity {

    private ChronometerTimer cmTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        cmTimer=findViewById(R.id.cmTimer);
        getLifecycle().addObserver(cmTimer);
    }
}