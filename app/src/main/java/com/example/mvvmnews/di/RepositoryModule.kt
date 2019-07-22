package com.example.mvvmnews.di

import com.example.mvvmnews.data.repository.TopHeadlineRepository
import com.example.mvvmnews.data.source.TopHeadlineDataSource
import org.koin.dsl.module

val repositoryModule = module {

    single { TopHeadlineRepository(get()) as TopHeadlineDataSource }
}