package com.lastmile.wanicity.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lastmile.wanicity.R
import com.lastmile.wanicity.data.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val news: ArrayList<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News){
            Glide.with(itemView.img_preview.context)
                .load(news.urlToImage)
                .into(itemView.img_preview)
            itemView.txt_title.setText(news.title)
            itemView.txt_desc.setText(news.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_news,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.bind(news[position])

    override fun getItemCount(): Int = news.count()

    fun addData(list: List<News>){
        news.addAll(list)
    }
}