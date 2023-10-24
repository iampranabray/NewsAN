package com.example.anNews.component//import androidx.compose.material3.CenterAlignedTopAppBar
import NiaIcons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ANTopAppBar(
    onActionClick: () -> Unit,
    onNavigationIconClick: () -> Unit,
    text: String,
) {
//    Image(
//        painter = painterResource(id = R.drawable.blob), contentDescription = "",
//        //contentScale = ContentScale.FillBounds,
//        modifier = Modifier
//            .blur(
//                radiusX = 10.dp,
//                radiusY = 10.dp,
//                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
//            )
//            .offset(
//                y = -100.dp,)
//
//    )

    CenterAlignedTopAppBar(
//        modifier = Modifier.background(),

        title = { Text(text = text, fontWeight = FontWeight.Bold) },
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