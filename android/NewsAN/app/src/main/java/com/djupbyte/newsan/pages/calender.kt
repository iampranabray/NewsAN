package com.example.anNews.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalenderPage(navController: NavHostController, modifier: Modifier = Modifier) {
    val datePickerState = rememberDatePickerState()
    Column( modifier= Modifier.fillMaxSize().padding(top = 48.dp),) {
        Row (
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            horizontalArrangement=  Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Calendar",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,

                )
        }

        DatePicker(state = datePickerState,
            title= null, headline = null, showModeToggle = false)
    }
}