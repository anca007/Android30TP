package com.example.eni_shop.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository

class ListeArticleViewModel : ViewModel() {

    var articles = MutableLiveData<List<Article>>()

    fun getArticleList(): MutableLiveData<List<Article>> {
        articles.value = ArticleRepository.getAllArticles()
        return articles
    }

    fun getRandomArticle() : Article {
        return articles.value?.random()!!
    }


}