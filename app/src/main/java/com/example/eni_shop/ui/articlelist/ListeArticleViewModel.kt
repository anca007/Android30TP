package com.example.eni_shop.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import com.example.eni_shop.db.ArticleDatabase
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.services.ArticleService
import com.example.eni_shop.ui.articleview.DetailArticleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListeArticleViewModel(private val articleDAO: ArticleDAO) : ViewModel() {

    var articles = MutableLiveData<List<Article>>()

    fun getArticleList(): MutableLiveData<List<Article>> {
        viewModelScope.launch {
            articles.value = ArticleService.ArticleAPI.retrofitService.getAllArticles()
        }
        return articles
    }

    fun getArticlesFav(): MutableLiveData<List<Article>> {
        viewModelScope.launch(Dispatchers.IO) {
            articles.postValue(articleDAO.selectAll())
        }
        return articles
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return ListeArticleViewModel(
                    ArticleDatabase.getInstance(application.applicationContext).articleDAO()
                ) as T
            }
        }
    }


}