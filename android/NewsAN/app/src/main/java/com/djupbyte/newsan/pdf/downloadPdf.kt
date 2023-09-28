import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.InputStream

fun downloadPdf(pdfUrl: String): InputStream? {
    val client = OkHttpClient()
    var request =  Request.Builder().url(url = pdfUrl).build();
    val response: Response = client.newCall(request).execute()
    if (response.isSuccessful) {
        return response.body?.byteStream()
    }
    return null
}