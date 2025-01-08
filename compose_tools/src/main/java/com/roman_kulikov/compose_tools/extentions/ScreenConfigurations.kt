package com.roman_kulikov.compose_tools.extentions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

val ScreenWidth: Int
    @Composable
    get() {
        return LocalConfiguration.current.screenWidthDp
    }

val ScreenHeight: Int
    @Composable
    get() {
        return LocalConfiguration.current.screenHeightDp
    }

val ScreenOrientation: Int
    @Composable
    get() {
        return LocalConfiguration.current.orientation
    }