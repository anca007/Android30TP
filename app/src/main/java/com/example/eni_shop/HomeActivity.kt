package com.example.eni_shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eni_shop.ui.articleadd.AjoutArticleActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")

        if(title != null && price != null){
            Snackbar.make(
                findViewById(R.id.homeLayout),
                "Vous venez de créer " + title + " pour un montant de " + price + " €",
                Snackbar.LENGTH_SHORT
            ).show()
        }




        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            Intent(this, AjoutArticleActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}