package com.example.navigationdemo.to_be_deleted

import java.util.*

class NewMock(
    var brand: String,var summary: String,var newContent : String, var pictureUrl : String?, var initDate: Date
    ) {
    fun getElapsedMinutes(): String {
        val diff: Long = Date().time - initDate.time
        return diff.toString()
    }
}