package com.djupbyte.newsan

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.ui.graphics.vector.ImageVector



class BottomItems {
    val bottomItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = NiaIcons.Newspaper,
        ), BottomNavItem(
            name = "Calender",
            route = "calender",
            icon = NiaIcons.Calender,
        ), BottomNavItem(
            name = "Notifications",
            route = "notifications",
            icon = Icons.Rounded.Notifications,
        )
    )
}


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

//sealed class BottomNavItem1(
//    val name: String,
//    val route: String,
//    val icon: ImageVector,
//) {
//   object Home: BottomNavItem1(
//    name = "Home",
//    route = "home",
//    icon = Icons.Rounded.Home,
//    );
//    object Search: BottomNavItem1(
//    name = "Search",
//    route = "search",
//    icon = Icons.Rounded.Search,
//    )
//    object Cart:    BottomNavItem1(
//    name = "Create",
//    route = "add",
//    icon = Icons.Rounded.ShoppingCart,
//    )
//        object Setting: BottomNavItem1(
//    name = "Settings",
//    route = "settings",
//    icon = Icons.Rounded.Settings,
//    )
//}


