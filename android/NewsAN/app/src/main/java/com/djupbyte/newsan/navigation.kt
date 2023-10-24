package com.example.anNews

import PDFViewerScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.anNews.pages.CalenderPage
import com.example.anNews.pages.Cart
import com.example.anNews.pages.HomePage


@Composable
fun NavigationGraph(navController: NavHostController, onActionClick : ()->Unit){
    NavHost(navController = navController, startDestination = "home",){

        composable(homeRoute) {
            HomePage(
                onActionClick={
                    onActionClick()
                              },
                onHome = {
                navController.navigate("pdfView")
                              }, name = "home",navController= navController)

        }
        composable(calenderRoute) {
            CalenderPage(navController)
        }
        composable(notificationsRoute) {
            Cart(onHome = { navController.popBackStack() }, name = "cart")
        }
        composable("pdfView"){
            PDFViewerScreen( navController)
        }
    }
}

const val homeRoute ="home"
const val calenderRoute = "calender"
const val notificationsRoute = "notifications"

