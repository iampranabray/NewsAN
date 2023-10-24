package com.example.anNews.pages


//import com.designsystem.uicomponent.ANTopAppBar
import NiaIcons
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    onHome: () -> Unit,
    onActionClick:()->Unit,
    name: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
    ){
        Row (
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            horizontalArrangement=  Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "NewsAn",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,

            )
            Spacer(modifier = Modifier.weight(1.0f))
            //onActionClick
            IconButton(onClick = {onActionClick()}) {
                Icon(
                    imageVector = NiaIcons.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)
        ) {

            LazyVerticalGrid(

                columns = GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(20) {
                    Card(

                        onClick = {
                            //nestedGraphs()
                            onHome()
                            //navController.navigate("pdfView")
                        },

                        ) {

                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            FilledTonalIconButton(
                                colors = IconButtonDefaults.filledTonalIconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                onClick = { /*TODO*/ },

                                ) {
                                Icon(
                                    NiaIcons.Newspaper,
                                    contentDescription = "Localized description",
                                )

                            }
                            Text(
                                text = "Aug 12,2023",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }
            }


        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBox(name: String, onNameChanged: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {

//        if (name.isNotEmpty()) {
//            Text(
//                text = "Hello, $name!",
//                modifier = Modifier.padding(bottom = 8.dp),
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//        OutlinedTextField(value = name, onValueChange = onNameChanged, label = { Text("Name") })
        }
    }

    @Composable
    fun HostState() {
        var name by rememberSaveable { mutableStateOf("") }
        SearchBox(name = name, onNameChanged = { name = it })
    }
}
//@Composable
//fun PdfViewerScreen(viewModel: PdfViewModel = viewModel()) {
//    val pdfState = viewModel.pdfState.collectAsState()
//
//    pdfState.value?.let { pdfViewerState ->
//        PdfViewer(
//            modifier = Modifier.fillMaxSize(),
//            state = pdfViewerState
//        )
//    } ?: run {
//        // Handle loading or error state here
//    }
//}

//        Text(
//            text = "Hello $name!", modifier = modifier
//        )

//        Button(onClick = onHome) {
//            Text("Go to Settings")
//        }

