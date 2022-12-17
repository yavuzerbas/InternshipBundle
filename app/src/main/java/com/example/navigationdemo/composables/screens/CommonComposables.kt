package com.example.navigationdemo.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

import com.example.navigationdemo.model.Util
import com.example.navigationdemo.model.New

@SuppressLint("NewApi")
@Composable
fun ContentOfNewBox(new: New, ExtraContent: @Composable() () -> Unit = {}){
    Column {
        if (new.newsDetail.imageDetail != null) { // && new.newsDetail.imageDetail.imageUrl != ""
            AsyncImage(model = new.newsDetail.imageDetail.imageUrl, contentDescription = null, modifier = Modifier.align(
                Alignment.CenterHorizontally)
            )
        }
        ChannelNameBox(new.newsDetail.newsChannelName)
        TitleBox(new.newsDetail.title)
        ExtraContent()
        ElapsedTimeBox(Util.getElapsedTime(new.newsDetail.pubDate))
    }
}
@Composable
fun TitleBox(str:String){
    Text(
        str,
        Modifier
            .padding(top = 10.dp, start = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
        //textAlign = TextAlign.Center
    )
}
@Composable
fun NewContent() {
    Text(
        "This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.This is just a fake new content.",
        Modifier
            .padding(top = 10.dp, start = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        fontSize = 15.sp
        //textAlign = TextAlign.Center
    )
}
@Composable
fun ElapsedTimeBox(str:String){
    Text(
        str,
        Modifier
            .padding(top = 10.dp, start = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        //textAlign = TextAlign.Center,
        color = Color.Gray,
        fontSize = 10.sp
    )
}
@Composable
fun ChannelNameBox(str: String){
    Text(
        str,
        Modifier
            .padding(top = 10.dp, start = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        //textAlign = TextAlign.Center,
        color = Color.Gray,
        fontSize = 14.sp
    )
}