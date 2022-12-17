package com.example.navigationdemo.model

data class BundlePostBody(
    val topicIds: List<Int>,
    val requestType: Int,
    val includePictures: Int
)