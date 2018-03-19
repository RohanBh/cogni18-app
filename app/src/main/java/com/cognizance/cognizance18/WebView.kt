package com.cognizance.cognizance18

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings

import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var webset: WebSettings = web_view.settings
        webset.javaScriptEnabled
        val url: String = intent.getStringExtra("url")
        web_view.loadUrl(url)
    }

}
