package com.djupbyte.newsan.pdf

import android.content.Context
import android.content.Intent
import android.net.Uri

fun sharePdf(context: Context, uri: Uri) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "application/pdf"
        putExtra(Intent.EXTRA_STREAM, uri)
    }

    context.startActivity(Intent.createChooser(shareIntent, "Share PDF"))
}