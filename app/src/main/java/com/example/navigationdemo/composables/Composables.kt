package com.example.navigationdemo

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.navigationdemo.model.New
import com.example.navigationdemo.model.NewsJson
import com.example.navigationdemo.model.Util
import com.example.navigationdemo.navigation.Screen

@Composable
fun LogoScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bundle),
            contentDescription = "Bundle Logo",
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Composable
fun SingleNewScreen(new: New?) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        if(new!=null) {
            Further(new)
        }
    }
}

@Composable
fun NewsScreen(navController: NavController, newJson: NewsJson?) {
    Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE2E5DE))
        ) {
            if(newJson != null){
                LeftSide(navController, Util.leftSideOfNews(newJson), Modifier.weight(1f))
                RightSide(navController, Util.rightSideOfNews(newJson), Modifier.weight(1f))
            }
        }
    }
}
@Composable
fun LeftSide(navController: NavController, newList: List<New>, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
        //.background(Color(0xFFE2E5DE))
    ) {
        Column/*(modifier = Modifier.verticalScroll(rememberScrollState()))*/{
            for (new in newList) {
                NewBox(navController, new = new, modifier = Modifier)
            }
        }
    }
}
@Composable
fun RightSide(navController: NavController, newList: List<New>, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
        //.background(Color.Green)
    ) {
        Column/*(modifier = Modifier.verticalScroll(rememberScrollState()))*/{
            for (new in newList) {
                NewBox(navController, new = new, modifier = Modifier)
            }
        }
    }
}
@Composable
fun NewBox(navController: NavController, new: New, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {/* globalNew = new;*/
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "newspaper",
                    value = new
                )
                navController.navigate(Screen.SingleNewScreen.route)
            })
            .padding(5.dp)
            .background(Color.White)
    ) {
        Further(new = new)
    }
}
@SuppressLint("NewApi")
@Composable
fun Further(new: New){
    Column {
        if (new.newsDetail.imageDetail != null) { // && new.newsDetail.imageDetail.imageUrl != ""
            AsyncImage(model = new.newsDetail.imageDetail.imageUrl, contentDescription = null, modifier = Modifier.align(
                Alignment.CenterHorizontally)
            )
        }
        ChannelNameBox(new.newsDetail.newsChannelName)
        TitleBox(new.newsDetail.title)
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