package com.pack.jetpack;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.pack.jetpack.base.BaseViewModel;


public class TestViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    private Activity mActivity;
    private Context mContext;
//    创建LiveData对象
    private MutableLiveData<String> currentName;
//    获取LiveData对象
    public MutableLiveData<String> getCurrentName() {
        if (currentName==null){
            currentName=new MediatorLiveData<>();
        }
        return currentName;
    }

    @Override
    public void setActivity(Activity activity) {
        mActivity=activity;
        mContext=activity;
    }

    public class MasterFragment extends Fragment {
        private TestViewModel model;
    }
}