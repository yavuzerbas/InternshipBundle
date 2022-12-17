package com.example.navigationdemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageDetail(
    val height: Int,
    val imageUrl: String,
    val width: Int
):Parcelable