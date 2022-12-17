package com.example.navigationdemo

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationdemo.composables.LogoScreen
import com.example.navigationdemo.composables.SingleNewScreen
import com.example.navigationdemo.model.NewsJson
import com.example.navigationdemo.model.New
import com.example.navigationdemo.navigation.Screen

@Composable
fun SetupNavGraph(navController: NavHostController) /*: NavController*/{
    //val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LogoScreen.route) {
        composable(route = Screen.LogoScreen.route) {
            LogoScreen()
        }
        composable(route = Screen.NewsScreen.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<NewsJson>("news_json")
            NewsScreen(navController = navController, result)
        }
        composable(route = Screen.SingleNewScreen.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<New>("newspaper")
            SingleNewScreen(result)/*globalNew*/
        }
    }
    //return navController
}
//}