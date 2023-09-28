package com.example.anNews.pages

import NiaIcons
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Cart(onHome: () -> Unit, name: String, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn {
            items(20) {
                Card(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 12.dp),
                ) {
                    ListItem(
                        modifier = Modifier.clickable { println("Clicked") },
                        headlineContent = { Text("DT News 9 Sept 2023") },
                        trailingContent = {
                            FilledIconToggleButton(

                                onCheckedChange = {},
                                content = {
                                    Icon(NiaIcons.StarOutline ,
                                        contentDescription = "Localized description",)},
                                checked= true,
                                colors = IconButtonDefaults.iconToggleButtonColors(
                                    checkedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    checkedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    disabledContainerColor = MaterialTheme.colorScheme.onBackground.copy(
                                        alpha = NiaIconButtonDefaults.DisabledIconButtonContainerAlpha,
                                    ),
                                )

                            )
                        },
                        leadingContent = {
                            Icon(
                                NiaIcons.Newspaper,
                                contentDescription = "Localized description",
                            )
                        })
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