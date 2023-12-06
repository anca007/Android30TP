package com.example.eni_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityMainBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.util.Date

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.article = Article(0, "", "", 0.0, "", null)

        //binding.article = ArticleRepository().getArticle(1)

        binding.button.setOnClickListener {

            val article = binding.article

            Snackbar.make(
                it,
                "Vous venez de créer " + article?.titre + " pour un montant de " + article?.prix + " €",
                Snackbar.LENGTH_SHORT
            ).show()
        }


    }


}