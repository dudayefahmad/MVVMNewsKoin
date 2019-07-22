package com.example.mvvmnews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmnews.R
import com.example.mvvmnews.data.State
import com.example.mvvmnews.data.remote.ArticlesItem
import com.example.mvvmnews.data.remote.TopHeadlines
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
        startObservingData()
    }

    private fun setUpRecyclerView() {
        rvNews.layoutManager = LinearLayoutManager(this)
        adapter.clickListener = {
            Snackbar.make(cl_root, it.title, Snackbar.LENGTH_SHORT).show()
        }
        rvNews.adapter = adapter
    }

    private fun startObservingData() {
        with(viewModel) {
            mainState.observe(this@MainActivity) {
                when (it) {
                    is State.Loading -> {
                        showLoading()
                    }
                    is State.Error -> {
                        showError()
                        Toast.makeText(this@MainActivity, it.throwable.message, Toast.LENGTH_SHORT).show()
                    }
                    is State.Success -> {
                        hideLoading()
                        showListNews(it.data)
                    }
                }
            }
        }
    }

    private fun showListNews(data: List<ArticlesItem>) {
        rvNews.visibility = VISIBLE
        adapter.listArticle = data
    }

    private fun showLoading() {
        progressView.visibility = VISIBLE
        rvNews.visibility = GONE
    }

    private fun hideLoading() {
        progressView.visibility = GONE
        rvNews.visibility = VISIBLE
    }

    private fun showError() {
        progressView.visibility = GONE
        rvNews.visibility = GONE
    }
}
