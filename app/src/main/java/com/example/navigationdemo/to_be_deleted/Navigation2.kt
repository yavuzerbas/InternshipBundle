package com.example.navigationdemo.to_be_deleted

class Navigation2 {

}

/*@Composable
fun MainScreen4(navController: NavController){
    var text by remember{
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ){
        TextField(value = text, onValueChange = {
            text = it
        },
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if(text.isNotEmpty())
                navController.navigate(Screen.DetailScreen.withArgs(text))
            else
                navController.navigate(Screen.DetailScreen.withArgs("sahip"))
        },
            modifier = Modifier.align(Alignment.End)
        ){
            Text("To DetailScreen")
        }
    }
}*/
/*@Composable
fun DetailScreen(name: String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text("Hello,$name")
    }
}*/
/*
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Yavuz"
                    nullable = true },
                navArgument("surname"){
                    type = NavType.StringType
                    defaultValue = "Erbas"
                    nullable = true }
            )
        ){
                entry->
            DetailScreen(name = entry.arguments?.getString("name"), surname = entry.arguments?.getString("surname") )
        }
    }
    navController.navigate(Screen.DetailScreen.withArgs("yavuz","erbas"))
     val timing = Timing()
     timing.start()
     var loopCtrl = true
     while(loopCtrl){
         if(timing.timeUp){
             //navController.navigate(Screen.DetailScreen.withArgs("sahip"))
             loopCtrl = false
         }
     }
}
 */
/*
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
                defaultValue = "Philipp"
                nullable = true
            })
            ){
            entry->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
    val timing = Timing()
    timing.start()
    var loopCtrl = true
    while(loopCtrl){
        if(timing.timeUp){
            //navController.navigate(Screen.DetailScreen.withArgs("sahip"))
            loopCtrl = false
        }
    }
}
 */