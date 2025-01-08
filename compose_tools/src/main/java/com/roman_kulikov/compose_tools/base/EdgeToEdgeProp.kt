package com.roman_kulikov.compose_tools.base

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge

/**
 * EdgeToEdgeProp contains param for set [enableEdgeToEdge] Activity function.
 */
data class EdgeToEdgeProp(
    val statusBarStyle: SystemBarStyle? = null,
    val navigationBarStyle: SystemBarStyle? = null
)
