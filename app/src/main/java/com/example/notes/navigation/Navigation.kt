package com.example.notes.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route){
            MainScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route+"/{name}",
            arguments = listOf(
                navArgument("details to Show") {
                    type = NavType.StringType
                    defaultValue = "foo"
                    nullable = false
                }
            )){
            DetailScreen(details = it.arguments?.getString("name")?:"foo")
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text: String by remember {
        mutableStateOf("starting text")
    }

    TextField(value = text, onValueChange = {
        text = it
    })
    Spacer(modifier = Modifier.width(1.dp))
    Button(onClick = {
           navController.navigate(Screen.DetailScreen.route+"/$text")
    }){
        Text("open details screen")
    }
}

@Composable
fun DetailScreen(details: String) {
    Text(details)
}
