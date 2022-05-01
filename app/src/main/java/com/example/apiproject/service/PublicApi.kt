package com.example.apiproject.service

import com.example.apiproject.model.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PublicApi {
    //https://api.publicapis.org/entries
    // BASEurl -> https://api.publicapis.org/
    // EXTurl -> entries
    companion object{
        const val ENTRIES = "entries"
    }

    @GET(ENTRIES)
    fun getData() : Single<ApiResponse>
}