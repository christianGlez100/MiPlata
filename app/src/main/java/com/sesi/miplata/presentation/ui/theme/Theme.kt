package com.sesi.miplata.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = MiPlataColors.md_theme_dark_primary,
    secondary = MiPlataColors.md_theme_dark_secondary,
    tertiary = MiPlataColors.md_theme_dark_tertiary,
    background = MiPlataColors.md_theme_dark_background,
    surface = MiPlataColors.md_theme_dark_surface,
    onPrimary = MiPlataColors.md_theme_dark_onPrimary,
    onSecondary = MiPlataColors.md_theme_dark_onSecondary,
    onTertiary = MiPlataColors.md_theme_dark_onTertiary,
    onBackground = MiPlataColors.md_theme_dark_onBackground,
    onSurface = MiPlataColors.md_theme_dark_onSurface,
    error = MiPlataColors.md_theme_dark_error,
    onError = MiPlataColors.md_theme_dark_onError,
    outline = MiPlataColors.md_theme_dark_outline
)

private val LightColorScheme = lightColorScheme(
    primary = MiPlataColors.md_theme_light_primary,
    secondary = MiPlataColors.md_theme_light_secondary,
    tertiary = MiPlataColors.md_theme_light_tertiary,
    background = MiPlataColors.md_theme_light_background,
    surface = MiPlataColors.md_theme_light_surface,
    onPrimary = MiPlataColors.md_theme_light_onPrimary,
    onSecondary = MiPlataColors.md_theme_light_onSecondary,
    onTertiary = MiPlataColors.md_theme_light_onTertiary,
    onBackground = MiPlataColors.md_theme_light_onBackground,
    onSurface = MiPlataColors.md_theme_light_onSurface,
    error = MiPlataColors.md_theme_light_error,
    onError = MiPlataColors.md_theme_light_onError,
    outline = MiPlataColors.md_theme_light_outline
)

@Composable
fun MiPlataTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MiPlataTypography,
        content = content
    )
}
