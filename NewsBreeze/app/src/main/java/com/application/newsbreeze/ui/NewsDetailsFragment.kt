package com.application.newsbreeze.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import com.application.newsbreeze.R
import com.application.newsbreeze.databinding.FragmentNewsDetailsBinding
import com.bumptech.glide.Glide


class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {

    lateinit var newsDetailsBinding: FragmentNewsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_news_details, container, false)
        return newsDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingDetails()

    }

    private fun settingDetails() {
        parentFragmentManager.setFragmentResultListener(
            "article", this, FragmentResultListener() { s: String, bundle: Bundle ->
                val author = bundle.getString("author")
                val content = bundle.getString("content")
                val description = bundle.getString("description")
                val publishedAt = bundle.getString("publishedAt")
                val source = bundle.getString("source")
                val title = bundle.getString("title")
                val url = bundle.getString("url")
                val urlToImage = bundle.getString("urlToImage")
                Glide.with(newsDetailsBinding.ivImagePreview).load(urlToImage).into(newsDetailsBinding.ivImagePreview)
            }
        )
    }

}
/*
/*
  @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
 */
 */