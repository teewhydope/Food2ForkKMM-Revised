package com.teewhy.food2forkkmm.data.recipedetail.repository

import com.teewhy.food2forkkmm.data.recipedetail.datasource.remote.RecipeRemoteSource
import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipedetail.RecipeRepository

class RecipeRepositoryImpl(
    private val recipeRemoteSource: RecipeRemoteSource,
    private val recipeDataToDomainMapper: RecipeDataToDomainMapper
) : RecipeRepository {
    override suspend fun recipe(id: Int): RecipeDomainModel {
        val data = recipeRemoteSource.recipe(id)
        return recipeDataToDomainMapper.toDomain(model = data)
    }
}
