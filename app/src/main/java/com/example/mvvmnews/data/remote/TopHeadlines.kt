package com.example.mvvmnews.data.remote


data class TopHeadlines(

	val totalResults: Int,
	val articles: List<ArticlesItem>,
	val status: String
)