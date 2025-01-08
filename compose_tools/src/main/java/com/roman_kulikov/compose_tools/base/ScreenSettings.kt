package com.roman_kulikov.compose_tools.base

import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable


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