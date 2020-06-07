package com.tusharp161.kotlinbootcamp.view

import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse

interface ICountryItemClickListener {
    fun onItemClick(country: CountryResponse)
}