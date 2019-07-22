package com.example.mvvmnews.data.repository

import com.example.mvvmnews.BuildConfig
import com.example.mvvmnews.data.ApiService
import com.example.mvvmnews.data.remote.ArticlesItem
import com.example.mvvmnews.data.remote.TopHeadlines
import com.example.mvvmnews.data.source.TopHeadlineDataSource

class TopHeadlineRepository(
    private val apiService: ApiService
) : TopHeadlineDataSource {

    override suspend fun getArticleList(): List<ArticlesItem> {
        return apiService.getArticles("id", BuildConfig.API_KEY).articles
    }

}