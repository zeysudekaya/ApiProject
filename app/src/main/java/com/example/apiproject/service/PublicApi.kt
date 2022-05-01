package com.example.apiproject.service

import com.example.apiproject.model.Entries
import com.example.apiproject.model.Response
import io.reactivex.Single
import retrofit2.http.GET

interface PublicApi {
    //https://api.publicapis.org/entries
    // BASEurl -> https://api.publicapis.org/
    // EXTurl -> entries
    companion object{
        const val PUBLIC_API = "entries"
    }

    @GET(PUBLIC_API)
    fun getData() : Single<Entries>
}