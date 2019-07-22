package com.example.mvvmnews.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnews.R
import com.example.mvvmnews.data.remote.ArticlesItem
import com.example.mvvmnews.util.loadImageUrl
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.NewsViewHolder>() {

    var listArticle: List<ArticlesItem> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var clickListener : (ArticlesItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listArticle[position])
    }


    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: ArticlesItem) {
            itemView.tvName.text = article.title
            itemView.tvDescription.text = article.description
            itemView.imgIcon.loadImageUrl(article.urlToImage)
            itemView.setOnClickListener {
                clickListener(article)
            }
        }
    }

}