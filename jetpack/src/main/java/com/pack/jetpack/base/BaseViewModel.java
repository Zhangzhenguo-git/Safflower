package com.pack.jetpack.base;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    public abstract void setActivity(Activity activity);
}
