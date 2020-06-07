package com.tusharp161.kotlinbootcamp.domain.repository

import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse

interface ICountryRepository : Repository {

    suspend fun getAllCountries() : List<CountryResponse>?
}