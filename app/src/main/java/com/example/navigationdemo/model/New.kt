package com.example.navigationdemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class New(
    val addButton: Boolean,
    val bundlePartner: String?, //String?
    val newsDetail: NewDetail,
    val newsLabelType: String,
    val readButton: Boolean
):Parcelable