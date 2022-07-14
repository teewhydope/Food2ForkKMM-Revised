package com.teewhy.food2forkkmm.data.recipelist.repository

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.data.local.RecipeLocalDataSource
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListRemoteSource
import com.teewhy.food2forkkmm.domain.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.mapper.RecipeListDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository

@Injectable(Scope.BY_USE)
class RecipeListRepositoryImpl(
    private val recipeListRemoteSource: RecipeListRemoteSource,
    private val recipeLocalDataSource: RecipeLocalDataSource,
    private val recipeDataToDomainMapper: RecipeDataToDomainMapper,
    private val recipeListDataToDomainMapper: RecipeListDataToDomainMapper
) : RecipeListRepository {
    override suspend fun recipeList(page: Int, query: String): RecipeListDomainModel {
        val data = recipeListRemoteSource.recipeList(page, query)
        recipeLocalDataSource.insert(data.results as List<RecipeDataModel>)

        val cacheResult = if (query.isBlank()) {
            recipeLocalDataSource.getAll(page = page)
        } else {
            recipeLocalDataSource.search(page = page, query = query)
        }

        val results: Collection<RecipeDomainModel> = cacheResult.map { index ->
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
