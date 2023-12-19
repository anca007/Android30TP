package com.example.eni_shop.ui.articleadd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.eni_shop.HomeActivity
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityAjoutArticleBinding
import com.example.eni_shop.repository.ArticleRepository

class AjoutArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAjoutArticleBinding
    lateinit var vm: AjoutArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjoutArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[AjoutArticleViewModel::class.java]

        binding.vm = vm

        binding.button.setOnClickListener {
            
            vm.addArticle()

            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title", vm.title)
                it.putExtra("price", vm.price.toString())
                startActivity(it)

            }


        }


    }


}