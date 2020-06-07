package com.tusharp161.kotlinbootcamp.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tusharp161.kotlinbootcamp.data.storage.entity.CountryEntity

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAllValue(countryList: List<CountryEntity>)

    @Query("SELECT * FROM CountryEntity")
    fun getValue(): List<CountryEntity>
}