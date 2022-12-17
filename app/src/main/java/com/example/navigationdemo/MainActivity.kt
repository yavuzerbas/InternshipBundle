package com.example.navigationdemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationdemo.model.NewsJson
import com.example.navigationdemo.api.RestApiService
import com.example.navigationdemo.model.Util
import com.example.navigationdemo.navigation.Screen
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    var navController: NavHostController? = null
    var newsJsonGlobal : NewsJson by Delegates.observable(Util.getMockNews()){
            _, _, _ -> run{
            //TODO navController!!.popBackStack()
            navController!!.currentBackStackEntry?.savedStateHandle?.set(
                key = "news_json",
                value = newsJsonGlobal
            )
            navController!!.navigate(Screen.NewsScreen.route)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController!!)
        }
        askNews()
    }
    private fun askNews(){
        val apiService = RestApiService()
        apiService.askNews(
            Util.getBodyJsonOfPostRequest(),
            onResult = {
                if (it != null) {
                    newsJsonGlobal = it
                }
            } )
    }
}


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Navigation()
}
*/