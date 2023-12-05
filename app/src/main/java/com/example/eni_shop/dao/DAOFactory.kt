package com.example.eni_shop.dao

import com.example.eni_shop.dao.memory.ArticleDaoMemoryImpl
import com.example.eni_shop.dao.network.ArticleDAONetworkImpl

abstract class DAOFactory {

    companion object {
        fun createArticleDAO(type: DaoType): ArticleDAO? {

            val dao: ArticleDAO?

            when (type) {
                DaoType.MEMORY -> dao = ArticleDaoMemoryImpl()
                DaoType.NETWORK -> dao = ArticleDAONetworkImpl()
                else -> dao = null
            }

            return dao
        }
    }
}