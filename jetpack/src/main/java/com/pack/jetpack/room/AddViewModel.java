package com.pack.jetpack.room;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pack.jetpack.room.database.WorksDao;
import com.pack.jetpack.room.database.WorksEntity;
import com.pack.jetpack.room.database.WorksRepository;


public class AddViewModel extends ViewModel {

    private Activity activity;
    private Context context;
    private WorksDao worksDao;
    private MutableLiveData<WorksEntity> itemWorks;
    // TODO: Implement the ViewModel
    public void initAddViewModel(Activity activity) {
        this.activity = activity;
        this.context = activity.getApplicationContext();
        worksDao = WorksRepository.getInstance(context).getWorksDao();
    }

    /**
     * 添加数据
     * @param arg0
     * @param arg1
     */
    public void insert(String arg0,String arg1){
        worksDao.insert(new WorksEntity(arg0,arg1));
    }
}