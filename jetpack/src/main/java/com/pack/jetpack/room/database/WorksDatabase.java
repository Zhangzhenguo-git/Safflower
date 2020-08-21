package com.pack.jetpack.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//数据库版本设置
@Database(entities = {WorksEntity.class},version = 1,exportSchema = false)
public abstract class WorksDatabase extends RoomDatabase {
    public abstract WorksDao getWorksDao();
}
