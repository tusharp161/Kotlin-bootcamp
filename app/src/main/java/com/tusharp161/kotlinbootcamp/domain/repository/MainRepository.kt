package com.tusharp161.kotlinbootcamp.domain.repository

import com.tusharp161.kotlinbootcamp.data.network.api.CountryService
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.data.storage.dao.MainDao
import javax.inject.Inject
import javax.inject.Named

class MainRepository @Inject constructor(
    @Named("server_url") val url: String,
    val mainDao: MainDao,
    val countryService: CountryService
) : ICountryRepository {

    override fun getData() : String{
        return url
    }

    override fun getAllCountries(): List<CountryResponse> {
        return countryService.getAllCountries()
    }
}