package com.application.newsbreeze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.newsbreeze.R
import com.application.newsbreeze.databinding.ItemLayoutBinding
import com.application.newsbreeze.remote.responses.Article
import com.bumptech.glide.Glide

class NewsBreezeAdapter(
    private val articleList: List<Article>
) : RecyclerView.Adapter<NewsBreezeAdapter.NewsBreezeViewHolder>() {

    //viewHolder
    class NewsBreezeViewHolder(private val itemLayoutBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        fun onBind(article: Article) {
            itemLayoutBinding.article = article
            Glide.with(itemLayoutBinding.ivImageArticle).load(article.urlToImage)
                .into(itemLayoutBinding.ivImageArticle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsBreezeViewHolder {
        val itemLayoutBinding: ItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout, parent, false
        )
        return NewsBreezeViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: NewsBreezeViewHolder, position: Int) {
        var article = articleList[position]
        holder.onBind(article)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

}