package com.tusharp161.kotlinbootcamp.di

import android.app.Application
import com.tusharp161.kotlinbootcamp.BootcampApplication
import com.tusharp161.kotlinbootcamp.di.module.ActivityBuilder
import com.tusharp161.kotlinbootcamp.di.module.ComposeModule
import com.tusharp161.kotlinbootcamp.di.module.PersistenceStorageModule
import com.tusharp161.kotlinbootcamp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        ComposeModule::class,
        PersistenceStorageModule::class]
)
interface AppComponent : AndroidInjector<BootcampApplication> {

    @Component.Factory
    interface Factory {
        fun application(@BindsInstance application: Application): AppComponent
    }

}