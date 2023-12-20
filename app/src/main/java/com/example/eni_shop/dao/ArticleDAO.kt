package com.example.eni_shop.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.eni_shop.bo.Article

@Dao
interface ArticleDAO {

    @Query("SELECT * FROM Article WHERE id = :id")
    fun selectById(id: Long): Article

    @Insert
    fun addNewOne(article: Article): Long

    @Query("SELECT * FROM Article")
    fun selectAll(): List<Article>

    @Delete
    fun deleteArticle(article: Article)

}