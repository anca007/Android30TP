package com.example.eni_shop.ui.articleadd

import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.utils.DateConverter

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
        ArticleRepository.addArticle(article)

    }


}