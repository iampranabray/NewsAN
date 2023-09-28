//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.github.barteksc.pdfviewer.PDFView
//import com.github.barteksc.pdfviewer.util.FitPolicy
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import java.io.IOException
//
//
//sealed class PdfViewerState {
//    object Loading : PdfViewerState()
//    data class Success(val pdfDocument: PDFView) : PdfViewerState()
//    data class Error(val exception: Exception) : PdfViewerState()
//
//}
//
//class PdfViewModel(
//
//) : ViewModel() {
//    private val _state = MutableStateFlow<PdfViewerState>(PdfViewerState.Loading)
//    val state: StateFlow<PdfViewerState> = _state
//
//
//    fun loadPdfFromUrl(pdfUrl: String, context: Context) {
//
//        viewModelScope.launch(Dispatchers.IO) {
//            val inputStream = downloadPdf(pdfUrl)
//            if (inputStream != null) {
//                val pdfView = PDFView(context, null)
//                pdfView.fromStream(inputStream).load()
//                _state.value = PdfViewerState.Success(pdfView)
//            } else {
//                _state.value = PdfViewerState.Error(IOException("PDF download failed"))
//            }
//
//        }
//
//    }
//}
