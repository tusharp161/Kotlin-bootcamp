package com.tusharp161.kotlinbootcamp.data.storage.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class MainEntity(
    @PrimaryKey val id: Int,
    val value: String
) : Parcelable