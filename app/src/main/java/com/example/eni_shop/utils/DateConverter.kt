package com.example.eni_shop.utils

import java.text.SimpleDateFormat
import java.util.Date

object DateConverter {

    @JvmStatic
    fun dateToSimpleString(date: Date?): String {

        if (date != null) {
            val format = SimpleDateFormat("dd/MM/yyyy")
            return format.format(date)
        } else {
            return ""
        }

    }

    @JvmStatic
    fun stringToSimpleDate(text: String): Date {

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        return dateFormat.parse(text)
    }
}