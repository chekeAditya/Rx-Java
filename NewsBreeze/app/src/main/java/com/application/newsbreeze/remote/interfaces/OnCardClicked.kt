package com.application.newsbreeze.remote.interfaces

import com.application.newsbreeze.remote.responses.Article

interface OnCardClicked {

    fun onCardClicked(article: Article)

}