package com.tusharp161.kotlinbootcamp.viewmodel

import androidx.lifecycle.ViewModel
import com.tusharp161.kotlinbootcamp.domain.repository.ICountryRepository
import com.tusharp161.kotlinbootcamp.domain.repository.MainRepository
import javax.inject.Inject

class CountryListViewModel @Inject constructor(private val mainRepository: ICountryRepository) :
    ViewModel() {

    fun getDataFromRepo() : String {
       return mainRepository.getData()
    }
}