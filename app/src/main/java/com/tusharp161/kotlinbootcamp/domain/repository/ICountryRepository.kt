package com.tusharp161.kotlinbootcamp.domain.repository

import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse

interface ICountryRepository : Repository {

    fun getAllCountries() : List<CountryResponse>

    fun getData() : String
}