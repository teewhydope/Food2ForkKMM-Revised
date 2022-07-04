package com.teewhy.food2forkkmm.data.recipelist.datasource.remote

import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeApiToDataMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.data.recipelist.mapper.RecipeListApiToDataMapper
import com.teewhy.food2forkkmm.data.recipelist.mapper.RecipeListApiToDataMapper.MapperInput
import com.teewhy.food2forkkmm.data.recipelist.model.RecipeListDataModel

class RecipeListRemoteDataSource(
    private val recipeListService: RecipeListService,
    private val recipeApiToDataMapper: RecipeApiToDataMapper,
    private val recipeListApiToDataMapper: RecipeListApiToDataMapper
) : RecipeListRemoteSource {
    override suspend fun recipeList(page: Int, query: String): RecipeListDataModel {
        val response = recipeListService.recipeList(page, query)
        val results: Collection<RecipeDataModel> = response.results.map { index ->
            recipeApiToDataMapper.toData(index)
        }

        return recipeListApiToDataMapper.toData(
            MapperInput(
                count = response.count,
                results = results
            )
        )
    }
}
