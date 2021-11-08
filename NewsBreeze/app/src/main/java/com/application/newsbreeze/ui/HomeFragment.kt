package com.application.newsbreeze.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.newsbreeze.R
import com.application.newsbreeze.adapter.NewsBreezeAdapter
import com.application.newsbreeze.databinding.FragmentHomeBinding
import com.application.newsbreeze.remote.interfaces.OnCardClicked
import com.application.newsbreeze.remote.responses.Article
import com.application.newsbreeze.viewmodels.ViewModelApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), OnCardClicked {

    var articleList = mutableListOf<Article>()
    lateinit var homeBinding: FragmentHomeBinding
    lateinit var newsBreezeAdapter: NewsBreezeAdapter
    private val viewModelApp: ViewModelApp by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsBreezeAdapter = NewsBreezeAdapter(articleList, this)
        homeBinding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = newsBreezeAdapter
        }

        viewModelApp.getDataFromApi().observe(viewLifecycleOwner, Observer {
            articleList.clear()
            articleList.addAll(it)
            newsBreezeAdapter.notifyDataSetChanged()
        })
    }

    override fun onCardClicked(article: Article) {
        val bundle = Bundle()
        bundle.putString("author",article.author)
        bundle.putString("content",article.content)
        bundle.putString("description",article.description)
        bundle.putString("publishedAt",article.publishedAt)
        bundle.putString("source", article.source.toString())
        bundle.putString("title",article.title)
        bundle.putString("url",article.url)
        bundle.putString("urlToImage",article.urlToImage)
        parentFragmentManager.setFragmentResult("article",bundle)

        //navigating
        Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_newsDetailsFragment)
    }

}
