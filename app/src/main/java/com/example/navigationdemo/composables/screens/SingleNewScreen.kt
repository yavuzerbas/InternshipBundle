package com.example.navigationdemo.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.example.navigationdemo.*
import com.example.navigationdemo.model.New

@Composable
fun SingleNewScreen(new: New?) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        if(new!=null) {
            ContentOfNewBox(new, { NewContent() })
        }
    }
}
