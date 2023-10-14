package com.example.anNews.pages

import NiaIcons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Cart(onHome: () -> Unit, name: String, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        LazyColumn {
            items(20) {

                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp, end = 8.dp, bottom = 12.dp),
                ) {

                    Row (
                        Modifier.fillMaxSize()
                            .padding(4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Row {
                            Icon(
                                NiaIcons.Info,
                                contentDescription = "Localized description",
                            )
                            Box(modifier = Modifier.padding(start = 8.dp))
                            Text("DT News 9 Sept 2023")
                        }


                        IconToggleButton(

                            onCheckedChange = {},
                            content = {
                                Icon(NiaIcons.StarOutline ,
                                    contentDescription = "Localized description",)},
                            checked= true,


                        )
                    }
//                    ListItem(
//                        modifier = Modifier.fillMaxSize().background(color = Color.Blue),
//
//
//                        headlineContent = { Text("DT News 9 Sept 2023") },
//                        trailingContent = {
//                            FilledIconToggleButton(
//
//                                onCheckedChange = {},
//                                content = {
//                                    Icon(NiaIcons.StarOutline ,
//                                        contentDescription = "Localized description",)},
//                                checked= true,
//                                colors = IconButtonDefaults.iconToggleButtonColors(
//                                    checkedContainerColor = MaterialTheme.colorScheme.primaryContainer,
//                                    checkedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
//                                    disabledContainerColor = MaterialTheme.colorScheme.onBackground.copy(
//                                        alpha = NiaIconButtonDefaults.DisabledIconButtonContainerAlpha,
//                                    ),
//                                )
//
//                            )
//                        },
//                        leadingContent = {
//
//                        })
                }
            }


        }


    }

}

object NiaIconButtonDefaults {
    // TODO: File bug
    // IconToggleButton disabled container alpha not exposed by IconButtonDefaults
    const val DisabledIconButtonContainerAlpha = 0.12f
}