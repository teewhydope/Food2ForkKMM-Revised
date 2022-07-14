package com.teewhy.food2forkkmm.data.recipedetail.repository

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.data.local.RecipeLocalDataSource
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.domain.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipedetail.RecipeRepository

@Injectable(Scope.BY_USE)
class RecipeRepositoryImpl(
    // private val recipeRemoteSource: RecipeRemoteSource,
    private val recipeLocalDataSource: RecipeLocalDataSource,
    private val recipeDataToDomainMapper: RecipeDataToDomainMapper
) : RecipeRepository {
    override suspend fun recipe(id: Int): RecipeDomainModel {
        val data = recipeLocalDataSource.get(id)
        return recipeDataToDomainMapper.toDomain(model = (data ?: {}) as RecipeDataModel)
    }
}
