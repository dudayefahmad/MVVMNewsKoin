package com.example.mvvmnews.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module

val appModule = module {
    single { GsonBuilder().setLenient().create() }
}