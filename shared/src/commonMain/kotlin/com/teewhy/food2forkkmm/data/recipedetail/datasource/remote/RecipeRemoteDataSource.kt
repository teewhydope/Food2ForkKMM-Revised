package com.teewhy.food2forkkmm.data.recipedetail.datasource.remote

import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeApiToDataMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

class RecipeRemoteDataSource(
    private val recipeService: RecipeService,
    private val recipeApiToDataMapper: RecipeApiToDataMapper
) : RecipeRemoteSource {
    override suspend fun recipe(id: Int): RecipeDataModel {
        val recipeResponse = recipeService.recipe(id)
        return recipeApiToDataMapper.toData(recipeResponse)
    }
}
