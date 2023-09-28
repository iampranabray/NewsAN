package com.example.anNews

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.anNews.pages.Cart
import com.example.anNews.pages.HomePage
import com.example.anNews.pages.CalenderPage


@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomePage(onHome = { navController.popBackStack() }, name = "home")
        }
        composable("calender") {
            CalenderPage(navController)
        }
        composable("notifications") {
            Cart(onHome = { navController.popBackStack() }, name = "cart")
        }
    }
}
