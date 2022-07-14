package com.teewhy.food2forkkmm.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.teewhy.food2forkkmm.android.ui.recipedetail.RecipeDetailScreen
import com.teewhy.food2forkkmm.android.ui.recipelist.RecipeListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) {
            RecipeListScreen(
                onClickRecipeListItem = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
                }
            )
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(
                navArgument(name = "recipeId") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            RecipeDetailScreen(
                recipeId = navBackStackEntry.arguments?.getInt("recipeId")
            )
        }
    }
}
