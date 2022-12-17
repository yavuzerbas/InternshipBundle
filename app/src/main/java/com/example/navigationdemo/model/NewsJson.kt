package com.example.navigationdemo.model

import android.os.Parcelable
import com.example.navigationdemo.model.New
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsJson(
    val followersCount: Int,
    val newsList: List<New>
): Parcelable
