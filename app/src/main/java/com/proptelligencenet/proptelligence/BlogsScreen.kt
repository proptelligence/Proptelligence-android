package com.proptelligencenet.proptelligence

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BlogsScreen(navController: NavController) {
    val mUrl = "https://coil-kt.github.io/coil/"

    AndroidView(factory = { context ->
        WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                    super.onReceivedError(view, errorCode, description, failingUrl)
                    // Log or handle the error here
                }
            }
        }
    }, update = { webView ->
        webView.loadUrl(mUrl)
    })
}

@Preview(showBackground = true)
@Composable
fun BlogsScreenPreview() {
    BlogsScreen(rememberNavController())
}