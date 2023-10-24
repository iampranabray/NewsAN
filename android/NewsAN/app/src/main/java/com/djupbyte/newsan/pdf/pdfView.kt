
import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.djupbyte.newsan.pdf.downloadAndSavePdf
import com.djupbyte.newsan.pdf.sharePdf
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File


@Composable
fun PDFViewerScreen(
    navController: NavHostController
) {
    val context: Context = LocalContext.current

    val pdfUrl =
        "https://dt.andaman.gov.in/epaper/2310202391130849.pdf" // Replace with your PDF URL
    val pdfFileName = "2310202391130858.pdf" // Change to your desired file name

    var pdfUri: String? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val downloadedUri = downloadAndSavePdf(pdfUrl, pdfFileName, context)
            downloadedUri?.let { uri ->
                pdfUri = uri
            }
        }

    }

    if(pdfUri.isNullOrEmpty()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                //progress = downloadProgress / 100f,
            )
        }

    }


    pdfUri?.let { uri ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 28.dp),

            verticalArrangement = Arrangement.Bottom
            ) {
            Row {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = NiaIcons.ArrowBack,
                        contentDescription = "",

                    )
                }
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    "12 Aug,2023",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White),

                    )
                Spacer(modifier = Modifier.weight(1.0f))
                IconButton(onClick = {
                    sharePdf(context,Uri.parse(uri) )
                }) {
                    Icon(
                        imageVector = NiaIcons.Share,
                        contentDescription = "",

                        )
                }
            }

            PdfRenderer(uri)
        }
    }

}

@Composable
fun PdfRenderer(pdfUri: String) {
    Scaffold(

    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


//            TopicToolbar(
////                onBackClick = onBackClick,
////                onFollowClick = onFollowClick,
////                uiState = topicUiState.followableTopic,
//            )
            AndroidView(
                factory = { context ->
                    val adView = PDFView(context, null)
                    adView.fromFile(File(pdfUri))
                        .enableDoubletap(true)
                        .spacing(10)
                        .load()
                    adView

                },
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}





@Composable
private fun TopicToolbar(
    //uiState: FollowableTopic,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onFollowClick: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = NiaIcons.ArrowBack,
                contentDescription = "",
            )
        }
        //val selected = uiState.isFollowed
//        NiaFilterChip(
//            selected = selected,
//            onSelectedChange = onFollowClick,
//            modifier = Modifier.padding(end = 24.dp),
//        ) {
//            if (selected) {
//                Text("FOLLOWING")
//            } else {
//                Text("NOT FOLLOWING")
//            }
//        }
    }
}