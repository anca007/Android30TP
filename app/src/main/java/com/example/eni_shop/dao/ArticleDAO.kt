package com.example.eni_shop.dao

import com.example.eni_shop.bo.Article

interface ArticleDAO {

    fun selectById(id : Long) : Article

    fun addNewOne(article : Article) : Long

}