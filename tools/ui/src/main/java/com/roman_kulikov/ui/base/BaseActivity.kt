package com.roman_kulikov.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

/**
 * This is a base Activity for JetPack compose.
 * Extend your activity from it.
 *
 * @param settings -> this is a [ScreenSettings].
 */

open class BaseActivity(private val settings: ScreenSettings = ScreenSettings()) : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnableEdgeToEdge()
        setContent(content = settings.content)
    }

    private fun setEnableEdgeToEdge() {
        if (settings.edgeToEdgeEnabling) {
            settings.edgeProp?.let { prop ->
                if (prop.statusBarStyle != null && prop.navigationBarStyle != null) {
                    enableEdgeToEdge(prop.statusBarStyle, prop.navigationBarStyle)
                } else if (prop.statusBarStyle != null) {
                    enableEdgeToEdge(prop.statusBarStyle)
                } else if (prop.navigationBarStyle != null) {
                    enableEdgeToEdge(navigationBarStyle =  prop.navigationBarStyle)
                } else {
                    enableEdgeToEdge()
                }
            } ?: enableEdgeToEdge()
        }
    }


}