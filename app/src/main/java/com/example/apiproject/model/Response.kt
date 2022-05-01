package com.example.apiproject.model

import com.google.gson.annotations.SerializedName

data class Response(

    @field:SerializedName("entries")
	val entries: List<ApiResponse?>? = null,

    @field:SerializedName("count")
	val count: Int? = null
)