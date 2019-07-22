package com.example.mvvmnews.data.remote

import com.google.gson.annotations.SerializedName

data class ArticlesItem(

	val publishedAt: String,
	val author: String,
	val urlToImage: String,
	val description: String,
	val source: Source,
	val title: String,
	val url: String,
	val content: String
)