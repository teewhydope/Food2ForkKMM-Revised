package com.teewhy.food2forkkmm.data.recipedetail.datasource.remote

import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

interface RecipeRemoteSource {
    suspend fun recipe(
        id: Int
    ): RecipeDataModel
}
