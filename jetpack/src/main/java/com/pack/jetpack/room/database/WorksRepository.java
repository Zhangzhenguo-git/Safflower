package com.pack.jetpack.room.database;

import android.content.Context;

import androidx.room.Room;

//数据库服务
public class WorksRepository {

    private static WorksRepository instance;
    private WorksDatabase worksDatabase;
    private WorksDao worksDao;

    /**
     * 有参构造方法
     * @param context
     */
    private WorksRepository(Context context){
//        实例化数据库
//        allowMainThreadQueries在主线程创建
        worksDatabase= Room.databaseBuilder(context,WorksDatabase.class,"works_db").allowMainThreadQueries().build();
        worksDao=worksDatabase.getWorksDao();
    }

    /**
     * 静态类同步锁单例
     * @param context
     * @return
     */
    public static WorksRepository getInstance(Context context){
        if (instance==null){
//            同步锁方法
            synchronized (WorksRepository.class){
                if (instance==null){
                    instance=new WorksRepository(context);
                }
            }
        }
        return instance;
    }

    /**
     * 获取数据库dao
     * @return
     */
    public WorksDao getWorksDao(){
        return worksDao;
    }
}
