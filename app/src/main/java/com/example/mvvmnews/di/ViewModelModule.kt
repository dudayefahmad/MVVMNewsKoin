package com.example.mvvmnews.di

import com.example.mvvmnews.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModuleModule = module {
    viewModel { MainViewModel(get()) }
}