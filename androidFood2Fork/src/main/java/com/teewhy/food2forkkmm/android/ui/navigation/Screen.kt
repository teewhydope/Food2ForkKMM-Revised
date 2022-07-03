package com.teewhy.food2forkkmm.android.ui.navigation

sealed class Screen(
    val route: String
) {
    object RecipeList : Screen(route = "recipeList")

    object RecipeDetail : Screen(route = "recipeDetail")
}
