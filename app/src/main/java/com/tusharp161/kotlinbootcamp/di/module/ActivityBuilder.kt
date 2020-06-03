package com.tusharp161.kotlinbootcamp.di.module

import com.tusharp161.kotlinbootcamp.view.CountryListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeCountryListActivity(): CountryListActivity

}