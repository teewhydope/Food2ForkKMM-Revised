package com.teewhy.food2forkkmm.presentation.recipelist.model

import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel

data class RecipeListPresentationModel(
    val count: Int,
    val results: Collection<RecipePresentationModel>
)
