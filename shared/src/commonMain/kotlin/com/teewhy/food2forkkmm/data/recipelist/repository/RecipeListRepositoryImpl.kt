package com.teewhy.food2forkkmm.data.recipelist.repository

import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListRemoteSource
import com.teewhy.food2forkkmm.data.recipelist.mapper.RecipeListDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository

class RecipeListRepositoryImpl(
    private val recipeListRemoteSource: RecipeListRemoteSource,
    private val recipeDataToDomainMapper: RecipeDataToDomainMapper,
    private val recipeListDataToDomainMapper: RecipeListDataToDomainMapper
) : RecipeListRepository {
    override suspend fun recipeList(page: Int, query: String): RecipeListDomainModel {
        val data = recipeListRemoteSource.recipeList(page, query)
        val results: Collection<RecipeDomainModel> = data.results.map { index ->
            recipeDataToDomainMapper.toDomain(index)
        }

        return recipeListDataToDomainMapper.toDomain(
            RecipeListDataToDomainMapper.MapperInput(
                count = data.count,
                results = results
            )
        )
    }
}
