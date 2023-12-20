package com.example.eni_shop.dao.memory

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import java.util.Date

class ArticleDaoMemoryImpl : ArticleDAO {

    companion object{

        private var articlesInMemory: MutableList<Article> = mutableListOf(
            Article(1, "Souris", "Souris sans fil", 10.0, "", Date()),
            Article(2, "Ecran", "Ecran sans fil", 100.0, "", Date()),
            Article(3, "Clavier", "Clavier sans fil", 18.0, "", Date()),
        )

    }


    override fun selectById(id: Long): Article {
        var article: Article? = null

        article = articlesInMemory.first() {
            it.id == id
        }
        return article
    }

    override fun addNewOne(article: Article): Long {
        article.id = articlesInMemory.size + 1L
        articlesInMemory.add(article)
        return article.id
    }

    override fun selectAll(): List<Article> {
       return articlesInMemory
    }

    override fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }


}