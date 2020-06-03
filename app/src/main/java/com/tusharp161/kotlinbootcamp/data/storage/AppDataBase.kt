package com.tusharp161.kotlinbootcamp.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tusharp161.kotlinbootcamp.data.storage.dao.MainDao
import com.tusharp161.kotlinbootcamp.data.storage.entity.MainEntity

@Database(
    entities = [MainEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun mainDao(): MainDao
}