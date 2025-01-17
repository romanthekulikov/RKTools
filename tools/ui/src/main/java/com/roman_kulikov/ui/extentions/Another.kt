package com.roman_kulikov.ui.extentions

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val CurrentContext: Context
    @Composable
    get() = LocalContext.current
