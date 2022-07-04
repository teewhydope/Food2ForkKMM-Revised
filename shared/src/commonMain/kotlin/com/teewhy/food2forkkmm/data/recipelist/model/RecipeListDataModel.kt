package com.teewhy.food2forkkmm.data.recipelist.model

import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

data class RecipeListDataModel(
    val count: Int,
    val results: Collection<RecipeDataModel>
)
