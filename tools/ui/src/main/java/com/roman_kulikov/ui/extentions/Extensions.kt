package com.roman_kulikov.ui.extentions

import android.widget.Toast
import androidx.compose.runtime.Composable

/**
 * Toast length
 * @property LENGTH_LONG -> equal [Toast.LENGTH_LONG]
 * @property LENGTH_SHORT -> equal [Toast.LENGTH_SHORT]
 */
enum class ToastLength(val value: Int) {
    LENGTH_LONG(Toast.LENGTH_LONG),
    LENGTH_SHORT(Toast.LENGTH_SHORT)
}

/**
 * Show [Toast] with String text via [CurrentContext]
 */
@Composable
fun StringToast(text: String, length: ToastLength) =
    Toast.makeText(CurrentContext, text, length.value).show()

/**
 * Show [Toast] via resource from [CurrentContext]
 */
@Composable
fun ResourceToast(res: Int, length: ToastLength) =
    Toast.makeText(CurrentContext, CurrentContext.getText(res), length.value).show()