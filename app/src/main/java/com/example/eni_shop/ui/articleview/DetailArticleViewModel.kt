package com.example.eni_shop.ui.articleview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import com.example.eni_shop.db.ArticleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailArticleViewModel(private val articleDAO: ArticleDAO) : ViewModel() {

    var fav = MutableLiveData<Boolean>(false)


    fun checkArticleFav(id: Long) {
        var article: Article? = null
        viewModelScope.launch(Dispatchers.IO) {
            article = articleDAO.selectById(id)
            if (article != null) {
                fav.postValue(true)
            }

        }
    }


    fun addArticleToFav(article: Article): MutableLiveData<Long> {
        var id = MutableLiveData<Long>()
        viewModelScope.launch(Dispatchers.IO) {
            id.postValue(articleDAO.addNewOne(article))
        }
        return id
    }

    fun deleteArticleFav(article: Article) {
        viewModelScope.launch(Dispatchers.IO) {
            articleDAO.deleteArticle(article)
        }
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

                return DetailArticleViewModel(
                    ArticleDatabase.getInstance(application.applicationContext).articleDAO()
                ) as T
            }
        }
    }

}