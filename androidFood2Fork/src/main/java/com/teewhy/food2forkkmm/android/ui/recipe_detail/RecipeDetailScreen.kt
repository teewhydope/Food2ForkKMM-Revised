package com.teewhy.food2forkkmm.android.ui.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailScreen(
    recipeId: Int?
) {
    Text(recipeId.toString())
}
