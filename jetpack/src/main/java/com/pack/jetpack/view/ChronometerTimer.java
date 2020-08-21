package com.pack.jetpack.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ChronometerTimer extends Chronometer implements LifecycleObserver {
    private long watchedTime;
    public ChronometerTimer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart(){
        setBase(SystemClock.elapsedRealtime()-watchedTime);
        start();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop(){
        watchedTime=SystemClock.elapsedRealtime()-getBase();
        stop();
    }
}
