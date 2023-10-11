package com.example.anNews.pages


//import com.designsystem.uicomponent.ANTopAppBar
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(onHome: () -> Unit, name: String, modifier: Modifier = Modifier) {

    HostState()


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

