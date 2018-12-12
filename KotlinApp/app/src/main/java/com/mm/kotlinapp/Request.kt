package com.mm.kotlinapp

import android.util.Log
import java.net.URL


public class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}