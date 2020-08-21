package com.pack.jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<Integer> tickPlus,tickReduce;

//    观察者实现
    public MutableLiveData<Integer> getTicePlus(){
        if (tickPlus==null) {
            tickPlus=new MutableLiveData<>();
            tickPlus.setValue(0);
        }
        return tickPlus;
    }

    public MutableLiveData<Integer> getTickReduce(){
        if (tickReduce==null) {
            tickReduce=new MutableLiveData<>();
            tickReduce.setValue(0);
        }

        return tickReduce;
    }

//    具体实现
    public void plusTick(){
        if (tickPlus.getValue()!=null) {
            tickPlus.setValue(tickPlus.getValue()+1);
        }
    }

    public void reduceTick(){
        if (tickReduce.getValue()!=null) {
            tickReduce.setValue(tickReduce.getValue()-1);
        }
    }
}
