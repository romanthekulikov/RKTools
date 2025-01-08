package com.roman_kulikov.compose_tools.extentions

import androidx.annotation.MainThread
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import kotlin.reflect.KType

/**
 * Navigate bottom to [route] Screen
 */
@MainThread
fun NavController.goBackTo(route: Any) {
    this.navigate(route) {
        popUpTo(0)
    }
}

/**
 * [NavGraphBuilder] extension for animate navigate from down to up
 * @param durationMillis -> navigation speed
 */
inline fun <reified T : Any> NavGraphBuilder.downUpComposable(
    durationMillis: Int,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    baseComposable<T>(
        durationMillis,
        typeMap,
        deepLinks,
        content,
        from = AnimatedContentTransitionScope.SlideDirection.Down,
        to = AnimatedContentTransitionScope.SlideDirection.Up
    )
}

/**
 * [NavGraphBuilder] extension for animate navigate from up to down
 * @param durationMillis -> navigation speed
 */
inline fun <reified T : Any> NavGraphBuilder.upDownComposable(
    durationMillis: Int,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    baseComposable<T>(
        durationMillis,
        typeMap,
        deepLinks,
        content,
        from = AnimatedContentTransitionScope.SlideDirection.Up,
        to = AnimatedContentTransitionScope.SlideDirection.Down
    )
}

/**
 * [NavGraphBuilder] extension for animate navigate from left to right
 * @param durationMillis -> navigation speed
 */
inline fun <reified T : Any> NavGraphBuilder.leftRightComposable(
    durationMillis: Int,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    baseComposable<T>(
        durationMillis,
        typeMap,
        deepLinks,
        content,
        from = AnimatedContentTransitionScope.SlideDirection.Left,
        to = AnimatedContentTransitionScope.SlideDirection.Right
    )
}

/**
 * [NavGraphBuilder] extension for animate navigate from right to left
 * @param durationMillis -> navigation speed
 */
inline fun <reified T : Any> NavGraphBuilder.rightLeftComposable(
    durationMillis: Int,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    baseComposable<T>(
        durationMillis,
        typeMap,
        deepLinks,
        content,
        from = AnimatedContentTransitionScope.SlideDirection.Right,
        to = AnimatedContentTransitionScope.SlideDirection.Left
    )
}

/**
 * [NavGraphBuilder] extension for animate navigation.
 * @param durationMillis -> navigation speed
 * @param from -> [AnimatedContentTransitionScope.SlideDirection] start direction
 * @param to -> [AnimatedContentTransitionScope.SlideDirection] close direction
 */
inline fun <reified T : Any> NavGraphBuilder.baseComposable(
    durationMillis: Int,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
    from: AnimatedContentTransitionScope.SlideDirection,
    to: AnimatedContentTransitionScope.SlideDirection
) {
    composable<T>(
        typeMap = typeMap,
        deepLinks = deepLinks,
        enterTransition = {
            slideIntoContainer(
                from,
                animationSpec = tween(durationMillis)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                to,
                animationSpec = tween(durationMillis)
            )
        },
        content = content
    )
}