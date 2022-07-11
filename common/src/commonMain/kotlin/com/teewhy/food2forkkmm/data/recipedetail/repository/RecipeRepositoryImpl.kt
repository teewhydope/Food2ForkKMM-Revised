package com.teewhy.food2forkkmm.data.recipedetail.repository

import com.teewhy.food2forkkmm.data.local.RecipeCache
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.domain.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipedetail.RecipeRepository

class RecipeRepositoryImpl(
    // private val recipeRemoteSource: RecipeRemoteSource,
    private val recipeCache: RecipeCache,
    private val recipeDataToDomainMapper: RecipeDataToDomainMapper
) : RecipeRepository {
    override suspend fun recipe(id: Int): RecipeDomainModel {
        val data = recipeCache.get(id)
        return recipeDataToDomainMapper.toDomain(model = (data ?: {}) as RecipeDataModel)
    }
}
