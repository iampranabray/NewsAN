package com.example.anNews.pages

import NiaIcons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Cart(onHome: () -> Unit, name: String, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
            horizontalArrangement=  Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Notifications",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,

                )
            //Spacer(modifier = Modifier)
            Switch(
                checked =true,
                onCheckedChange = {}
            )
        }


        LazyColumn {
            items(20) {

                Row (
                    Modifier
                        .fillMaxSize()
                        .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        FilledTonalIconButton(
                            onClick = { /*TODO*/ },

                            ) {
                            Icon(
                                NiaIcons.Newspaper,
                                contentDescription = "Localized description",
                            )
                        }

                        Box(modifier = Modifier.padding(start = 8.dp))
                        Column {
                            Text("Daily Telegram News", fontWeight = FontWeight.Bold)
                            Text("2/10/23", style = MaterialTheme.typography.labelSmall,)
                        }
                    }



                    IconToggleButton(

                        onCheckedChange = {},
                        content = {
                            Icon(NiaIcons.StarOutline ,
                                contentDescription = "Localized description",)
                        },
                        checked= true,


                        )
                }

                Divider(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 48.dp))

//                Card(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(start = 8.dp, end = 8.dp, bottom = 12.dp),
//                ) {
//
//
////                    ListItem(
////                        modifier = Modifier.fillMaxSize().background(color = Color.Blue),
////
////
////                        headlineContent = { Text("DT News 9 Sept 2023") },
////                        trailingContent = {
////                            FilledIconToggleButton(
////
////                                onCheckedChange = {},
////                                content = {
////                                    Icon(NiaIcons.StarOutline ,
////                                        contentDescription = "Localized description",)},
////                                checked= true,
////                                colors = IconButtonDefaults.iconToggleButtonColors(
////                                    checkedContainerColor = MaterialTheme.colorScheme.primaryContainer,
////                                    checkedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
////                                    disabledContainerColor = MaterialTheme.colorScheme.onBackground.copy(
////                                        alpha = NiaIconButtonDefaults.DisabledIconButtonContainerAlpha,
////                                    ),
////                                )
////
////                            )
////                        },
////                        leadingContent = {
////
////                        })
//                }
            }


        }


    }

}

object NiaIconButtonDefaults {
    // TODO: File bug
    // IconToggleButton disabled container alpha not exposed by IconButtonDefaults
    const val DisabledIconButtonContainerAlpha = 0.12f
}