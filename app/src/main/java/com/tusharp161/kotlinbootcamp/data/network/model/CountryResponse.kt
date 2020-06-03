package com.tusharp161.kotlinbootcamp.data.network.model

data class CountryResponse(val name:String,val flagUrl:String,val region: String,
                           val subRegion:String,val population:Int)