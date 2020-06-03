package com.tusharp161.kotlinbootcamp.di.module

import androidx.annotation.NonNull
import com.tusharp161.kotlinbootcamp.data.network.api.CountryService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
//      .addInterceptor(RequestInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl("https://restcountries.eu/rest/v2/")
      .addConverterFactory(GsonConverterFactory.create())
//      .addCallAdapterFactory(LiveDataCallAdapterFactory())
      .build()
  }

  @Provides
  @Singleton
  fun provideCountryService(@NonNull retrofit: Retrofit): CountryService {
    return retrofit.create(CountryService::class.java)
  }
}
