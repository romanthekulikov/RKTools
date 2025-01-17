package com.roman_kulikov.ui.base

import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.roman_kulikov.ui.base.EdgeToEdgeProp


/**
 * ScreenSettings contains:
 * @param edgeToEdgeEnabling -> Boolean type for enable [enableEdgeToEdge].
 * @param edgeProp -> [EdgeToEdgeProp] contain properties like in original [enableEdgeToEdge].
 * @param content -> This is the composable content of the screen.
 */
data class ScreenSettings(
    var edgeToEdgeEnabling: Boolean = false,
    var edgeProp: EdgeToEdgeProp? = null,
    var content: @Composable () -> Unit = { /* nothing */ }
)