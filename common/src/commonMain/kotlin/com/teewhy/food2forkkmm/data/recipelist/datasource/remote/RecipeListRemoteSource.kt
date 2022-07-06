package com.teewhy.food2forkkmm.data.recipelist.datasource.remote

import com.teewhy.food2forkkmm.data.recipelist.model.RecipeListDataModel

interface RecipeListRemoteSource {
    suspend fun recipeList(
        page: Int,
        query: String
    ): RecipeListDataModel
}
