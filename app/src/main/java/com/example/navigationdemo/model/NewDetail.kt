package com.example.navigationdemo.model

import android.os.Parcelable
import com.example.navigationdemo.model.ImageDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewDetail(
    val channelCategoryID: Int,
    val channelCategoryLocalizationKey: String,
    val content: String,
    val countryID: Int,
    val imageDetail: ImageDetail?,
    val link: String,
    val newsChannelID: Int,
    val newsChannelName: String,
    val pubDate: String,
    val rssDataID: String,
    val shareUrl: String,
    val title: String,
    val writerChannelCategory: String? //String?
):Parcelable