package com.tusharp161.kotlinbootcamp.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tusharp161.kotlinbootcamp.data.storage.entity.MainEntity

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAllValue(mainEntity: MainEntity)

    @Query("SELECT * FROM MainEntity")
    fun getValue(): List<MainEntity>
}