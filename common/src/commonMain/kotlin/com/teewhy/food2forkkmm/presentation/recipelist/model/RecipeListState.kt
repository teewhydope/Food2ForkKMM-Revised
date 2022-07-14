package com.teewhy.food2forkkmm.presentation.recipelist.model

import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel

/**
 * RecipeListState is a little different on iOS so need expect/actual
 */
data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val recipes: List<RecipePresentationModel> = listOf(),
    val selectedCategory: FoodCategory? = null
    // val queue: Queue<GenericMessageInfo> = Queue(mutableListOf()), // messages to be displayed in ui
)
