package com.example.apiproject.model

import com.google.gson.annotations.SerializedName

class Entries : ArrayList<Entries.EntriesItem>() {
	data class EntriesItem(

		@field:SerializedName("Description")
		val description: String? = null,

		@field:SerializedName("Category")
		val category: String? = null,

		@field:SerializedName("HTTPS")
		val hTTPS: Boolean? = null,

		@field:SerializedName("Auth")
		val auth: String? = null,

		@field:SerializedName("API")
		val aPI: String? = null,

		@field:SerializedName("Cors")
		val cors: String? = null,

		@field:SerializedName("Link")
		val link: String? = null
	)
}