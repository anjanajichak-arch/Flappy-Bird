package com.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          FlappyBirdGame(modifier = Modifier.padding(innerPadding).background(Color(0xFFFDF8F6)))
        }
      }
    }
  }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FlappyBirdGame(modifier: Modifier = Modifier) {
  AndroidView(
    modifier = modifier.fillMaxSize(),
    factory = { context ->
      WebView(context).apply {
        setBackgroundColor(android.graphics.Color.parseColor("#FDF8F6"))
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        webViewClient = WebViewClient()
        loadUrl("file:///android_asset/index.html")
      }
    }
  )
}
