package com.example.mvvmnews.data.remote.test

import com.google.gson.annotations.SerializedName

data class Test(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)