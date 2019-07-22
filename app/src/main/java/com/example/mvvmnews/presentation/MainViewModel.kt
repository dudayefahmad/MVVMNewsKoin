package com.example.mvvmnews.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmnews.data.State
import com.example.mvvmnews.data.remote.ArticlesItem
import com.example.mvvmnews.data.source.TopHeadlineDataSource
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val topHeadlineDataSource: TopHeadlineDataSource) : ViewModel() {
    val mainState = MutableLiveData<State<List<ArticlesItem>>>()

    init {
        getList()
    }

    fun getList() {
        mainState.postValue(State.Loading())
        viewModelScope.launch {
            try {
                val list = topHeadlineDataSource.getArticleList()
                mainState.postValue(State.Success(list))
            } catch (e: Exception) {
                mainState.postValue(State.Error(e))
            }
        }
    }
}
