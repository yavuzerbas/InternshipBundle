package com.example.navigationdemo.navigation

sealed class Screen(val route: String){
    object LogoScreen : Screen("logo_screen")
    object NewsScreen : Screen("news_screen")
    object SingleNewScreen : Screen("single_new_screen")

    /*fun withArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach {
                    arg -> append("/$arg")
            }
        }
    }*/
}
/*
sealed class LogoScreen(private val route:String) : Screen(route){
    object newsScreen : NewsScreen()
}
sealed class NewsScreen(route:String) : Screen(route){

}
sealed class SingleNewScreen(route:String) : Screen(route){

}*/
