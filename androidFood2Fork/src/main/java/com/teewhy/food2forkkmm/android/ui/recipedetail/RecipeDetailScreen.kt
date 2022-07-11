package com.teewhy.food2forkkmm.android.ui.recipedetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailScreen(
    recipeId: Int?
) {
    Text(recipeId.toString())
}
