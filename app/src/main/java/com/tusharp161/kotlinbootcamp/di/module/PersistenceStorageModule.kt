package com.tusharp161.kotlinbootcamp.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.tusharp161.kotlinbootcamp.data.network.api.CountryService
import com.tusharp161.kotlinbootcamp.data.storage.AppDataBase
import com.tusharp161.kotlinbootcamp.data.storage.dao.MainDao
import com.tusharp161.kotlinbootcamp.domain.repository.ICountryRepository
import com.tusharp161.kotlinbootcamp.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class PersistenceStorageModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDataBase {
        return Room
            .databaseBuilder(application, AppDataBase::class.java, "Countries.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMainDao(@NonNull appDataBase: AppDataBase): MainDao {
        return appDataBase.mainDao()
    }

    @Provides
    @Singleton
    fun providesRepository(mainDao: MainDao, countryService: CountryService
    ): ICountryRepository {
        return MainRepository(mainDao, countryService)
    }
}