package com.example.anNews.component//import androidx.compose.material3.CenterAlignedTopAppBar
import NiaIcons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ANTopAppBar(
    onActionClick: () -> Unit,
    onNavigationIconClick: () -> Unit,
    text: String,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = text,fontWeight= FontWeight.Bold) },

//        colors =
//        TopAppBarDefaults.centerAlignedTopAppBarColors(
//            //containerColor = MaterialTheme.colorScheme.background
//        ),
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = NiaIcons.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }

    )
}