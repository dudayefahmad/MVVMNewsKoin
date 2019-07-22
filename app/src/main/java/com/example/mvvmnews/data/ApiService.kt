package com.example.mvvmnews.data

import com.example.mvvmnews.data.remote.TopHeadlines
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ) : TopHeadlines
}