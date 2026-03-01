package com.example.praktikumtam_2417051033.model
import androidx.annotation.DrawableRes

data class Lifestyle(
    val title: String,
    val date: String,
    val mood: String,
    val note: String,
    @DrawableRes val imageRes: Int
)
