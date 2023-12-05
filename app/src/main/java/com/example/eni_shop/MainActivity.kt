package com.example.eni_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import java.util.Date

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val article = ArticleRepository().getArticle(1)

        val article = Article(0,
            "Barrete de RAM",
            "32 X 16 Go ram",
            25.0,
            "",
            Date())

        val id = ArticleRepository().addArticle(article)
        Log.i(TAG, "Id article généré : $id")


        val article2 = ArticleRepository().getArticle(id!!)
        Log.i(TAG, "Article = $article2")


    }









}