package com.example.anNews.component//import androidx.compose.material3.CenterAlignedTopAppBar
import android.graphics.drawable.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ANTopAppBar(
    onActionClick: () -> Unit,
    onNavigationIconClick: () -> Unit,
    text: String,
) {
    CenterAlignedTopAppBar(title = { Text(text = text) },

        colors =
        TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
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