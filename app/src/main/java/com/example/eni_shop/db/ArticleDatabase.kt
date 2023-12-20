package com.example.eni_shop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import com.example.eni_shop.utils.DateConverter

@Database(entities = [Article::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ArticleDatabase : RoomDatabase() {

    //lister les daos
    abstract fun articleDAO(): ArticleDAO


    //création du singleton de la base
    companion object {

        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase {

            var instance = INSTANCE

            if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "eni-shop"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
            }

            return instance
        }


    }


}