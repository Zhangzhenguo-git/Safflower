package com.pack.jetpack.room;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.pack.jetpack.room.database.WorksDao;
import com.pack.jetpack.room.database.WorksEntity;
import com.pack.jetpack.room.database.WorksRepository;

import java.util.List;

public class WorksViewModel extends ViewModel {

    private Activity activity;
    private Context context;
    private WorksDao worksDao;
    // TODO: Implement the ViewModel
    private MutableLiveData<List<WorksEntity>> worksLiveData;

    public void initWorksViewModel(Activity activity){
        this.activity=activity;
        this.context=activity.getApplicationContext();
        worksDao= WorksRepository.getInstance(context).getWorksDao();
    }

    /**
     * 添加
     * @param arg0
     * @param arg1
     */
    public void insert(String arg0,String arg1){
        worksDao.insert(new WorksEntity(arg0,arg1));
        if (worksLiveData==null){
            worksLiveData=new MediatorLiveData<>();
            worksLiveData.setValue(worksDao.getWorks());
        }
    }
    /**
     * 查询
     * @return
     */
    public String searchWorksData(){
//        if (worksLiveData==null){
//            worksLiveData=new MediatorLiveData<>();
//            worksLiveData.setValue(worksDao.getWorks());
//        }
//        List<WorksEntity> works=worksLiveData.getValue();
        List<WorksEntity> works=worksDao.getWorks();
        StringBuffer buffer =new StringBuffer();
        for (int i = 0; i <works.size() ; i++) {
            buffer.append(works.get(i).getWorks()).append(works.get(i).getName()).append("\n");
        }
        return buffer.toString();
    }

    /**
     * 删除
     */
    public String deleteWorksData(){
        worksDao.deleteAll();
        return searchWorksData();
    }

    /**
     * 修改
     */
    public String updateWorksData(){
        worksDao.update();
//        if (worksLiveData==null){
//            worksLiveData=new MediatorLiveData<>();
//            worksLiveData.setValue(worksDao.getWorks());
//        }
//        return worksLiveData.getValue();
        return searchWorksData();
    }

}