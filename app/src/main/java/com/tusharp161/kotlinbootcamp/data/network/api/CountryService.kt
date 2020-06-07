package com.tusharp161.kotlinbootcamp.data.network.api

import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    fun getAllCountries() : Call<List<CountryResponse>>
}