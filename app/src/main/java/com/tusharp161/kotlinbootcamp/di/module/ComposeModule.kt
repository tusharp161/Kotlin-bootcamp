package com.tusharp161.kotlinbootcamp.di.module

import com.tusharp161.kotlinbootcamp.base.ViewModelActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ComposeModule {

    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity
}
