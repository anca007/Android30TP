package com.example.eni_shop.bo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.eni_shop.utils.DateConverter
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity
@Parcelize
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @Json(name = "title")
    var titre: String,
    var description: String,
    @Json(name = "price")
    var prix: Double,
    @Json(name = "image")
    var urlImage: String,
    @Json(ignore = true)
    var dateSortie: Date? = Date()
) : Parcelable
