package com.pack.jetpack.room.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//数据库接口
@Dao
public interface WorksDao {

    @Insert
    void insert(WorksEntity... worksEntities);

    @Update
    void update(WorksEntity... worksEntities);

    @Query("select * from works")
    List<WorksEntity> getWorks();

    @Query("delete from works")
    void deleteAll();

    @Query("select * from works")
    DataSource.Factory<Integer,WorksEntity> getWorksForPaging();

}
