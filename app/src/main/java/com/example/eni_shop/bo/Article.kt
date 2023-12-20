package com.example.eni_shop.bo
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.eni_shop.utils.DateConverter
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity
@Parcelize
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var titre: String,
    var description: String,
    var prix: Double,
    var urlImage: String,
    var dateSortie: Date?
) : Parcelable
