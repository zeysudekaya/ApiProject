package com.example.apiproject.service

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PublicApiService {

   private val BASE_URL =  "https://api.publicapis.org/"

   private val retrofitApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PublicApi::class.java)

    fun getDataService(): Single<com.example.apiproject.model.Response> {
        return retrofitApi.getData()
    }
}