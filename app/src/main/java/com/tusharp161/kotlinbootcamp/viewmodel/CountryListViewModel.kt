package com.tusharp161.kotlinbootcamp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.domain.repository.ICountryRepository
import com.tusharp161.kotlinbootcamp.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryListViewModel @Inject constructor(private val mainRepository: ICountryRepository) :
    ViewModel() {

    val countryListLiveData:MutableLiveData<List<CountryResponse>> = MutableLiveData()

    fun getDataFromRepo()  {
        CoroutineScope(IO).launch {
            val list = mainRepository.getAllCountries()
            countryListLiveData.postValue(list)
        }
    }
}