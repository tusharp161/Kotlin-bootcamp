package com.tusharp161.kotlinbootcamp.domain.repository

import com.tusharp161.kotlinbootcamp.data.network.api.CountryService
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.data.storage.dao.MainDao
import javax.inject.Inject
import javax.inject.Named

class MainRepository @Inject constructor(
    val mainDao: MainDao,
    val countryService: CountryService
) : ICountryRepository {

    override suspend fun getAllCountries(): List<CountryResponse>? {
        var listOfCountries : List<CountryResponse>? = ArrayList()
        val response = countryService.getAllCountries().execute()
        if(response.isSuccessful){
            listOfCountries = response.body()
        }
        return listOfCountries
    }
}