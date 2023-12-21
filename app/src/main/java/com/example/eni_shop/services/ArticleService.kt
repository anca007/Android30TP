package com.example.eni_shop.services

import com.example.eni_shop.bo.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticleService {
    companion object {

        val BASE_URL = "https://fakestoreapi.com/"

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("products")
    suspend fun getAllArticles(): List<Article>

    @POST("products")
    suspend fun addNewArticle(@Body article: Article)

    object ArticleAPI {
        val retrofitService by lazy { retrofit.create(ArticleService::class.java) }
    }
}