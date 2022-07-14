package com.teewhy.food2forkkmm.android.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.teewhy.food2forkkmm.android.ui.components.CircularIndeterminateProgressBar

private val LightThemeColors = lightColors(
    primary = lightPurple,
    primaryVariant = darkPurple,
    onPrimary = Black2,
    secondary = Color.White,
    secondaryVariant = paleRed,
    // onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = lightPink,
    onBackground = Color.Black,
    surface = Color.White
    // onSurface = Black2
)

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Theme(
    displayProgressBar: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        typography = NeutonTypography,
        shapes = AppShapes
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = lightPink)
        ) {
            Column {
                content()
            }
            CircularIndeterminateProgressBar(isDisplayed = displayProgressBar, 0.3f)
        }
    }
}
