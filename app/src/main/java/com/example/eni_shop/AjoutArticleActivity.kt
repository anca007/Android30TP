package com.example.eni_shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityAjoutArticleBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class AjoutArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAjoutArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjoutArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.article = Article(0, "", "", 0.0, "", null)

        //binding.article = ArticleRepository().getArticle(1)

        binding.button.setOnClickListener {

            val article = binding.article

            ArticleRepository.addArticle(article!!)

            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title", article.titre)
                it.putExtra("price", article.prix.toString())
                startActivity(it)

            }


        }


    }


}