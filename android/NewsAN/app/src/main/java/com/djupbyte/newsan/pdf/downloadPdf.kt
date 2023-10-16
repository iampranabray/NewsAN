package com.djupbyte.newsan.pdf
import android.content.Context
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

//fun downloadPdf(pdfUrl: String): InputStream? {
//    val client = OkHttpClient()
//    var request =  Request.Builder().url(url = pdfUrl).build();
//    val response: Response = client.newCall(request).execute()
//    if (response.isSuccessful) {
//        return response.body?.byteStream()
//    }
//    return null
//}
fun downloadAndSavePdf(url: String, fileName: String, context: Context): String? {

    try {
        val directory = context.filesDir
        if (!directory.exists()) {
            directory.mkdirs();
        }
        val file = File(directory, fileName)

        if (!file.exists()) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            urlConnection.connect()
            val inputStream = BufferedInputStream(urlConnection.inputStream)

            val outputStream = FileOutputStream(file)

            val data = ByteArray(1024)
            var total: Long = 0
            var count: Int

            while (inputStream.read(data).also { count = it } != -1) {
                total += count.toLong()
                outputStream.write(data, 0, count)
            }

            outputStream.flush()
            outputStream.close()
            inputStream.close()
        }

        return file.path
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }


}