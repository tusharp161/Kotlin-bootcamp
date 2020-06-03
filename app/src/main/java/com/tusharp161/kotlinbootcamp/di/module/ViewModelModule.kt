package com.tusharp161.kotlinbootcamp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tusharp161.kotlinbootcamp.di.AppViewModelFactory
import com.tusharp161.kotlinbootcamp.di.annotation.ViewModelKey
import com.tusharp161.kotlinbootcamp.viewmodel.CountryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountryListViewModel::class)
    internal abstract fun bindMainActivityViewModels(countryListViewModel: CountryListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}