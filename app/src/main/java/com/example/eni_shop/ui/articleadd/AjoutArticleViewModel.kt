package com.example.eni_shop.ui.articleadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.services.ArticleService
import com.example.eni_shop.utils.DateConverter
import kotlinx.coroutines.launch

class AjoutArticleViewModel : ViewModel() {

    var title: String = ""
    var description: String = ""
    var price: Double = 0.0
    var date: String = ""

    fun addArticle() {
        val article = Article(
            0,
            this.title,
            this.description,
            this.price,
            "",
            DateConverter.stringToSimpleDate(date)
        )
        viewModelScope.launch {
            ArticleService.ArticleAPI.retrofitService.addNewArticle(article)
        }

    }


}