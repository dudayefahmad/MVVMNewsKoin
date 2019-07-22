package com.example.mvvmnews.data.source

import com.example.mvvmnews.data.remote.ArticlesItem
import com.example.mvvmnews.data.remote.TopHeadlines

interface TopHeadlineDataSource {
    suspend fun getArticleList(): List<ArticlesItem>
}