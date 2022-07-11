package com.teewhy.food2forkkmm.data.local

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.data.local.mapper.RecipeDataBaseToDataMapper
import com.teewhy.food2forkkmm.data.local.mapper.RecipeDataToDataBaseMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

@Injectable(Scope.BY_USE)
class RecipeCacheImpl(
    private val databaseDriverFactory: DriverFactory
) : RecipeCache {

    private val recipeDataBase = RecipeDataBase(databaseDriverFactory.createDriver())

    private var queries: RecipeDbQueries = recipeDataBase.recipeDbQueries

    override fun insert(recipe: RecipeDataModel) {
        val recipeDataToDataBaseMapper = RecipeDataToDataBaseMapper(recipeDataBase)
        recipeDataToDataBaseMapper.toDataBase(recipe)
    }

    override fun insert(recipes: List<RecipeDataModel>) {
        for (recipe in recipes) {
            insert(recipe)
        }
    }

    override fun search(query: String, page: Int): List<RecipeDataModel> {
        return queries.searchRecipes(
            query = query,
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList()
    }

    override fun getAll(page: Int): List<RecipeDataModel> {
        return queries.getAllRecipes(
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList()
    }

    override fun get(recipeId: Int): RecipeDataModel? {
        return queries.getRecipeById(id = recipeId.toLong()).executeAsOneOrNull()?.toRecipe()
    }

    fun List<Recipe_Entity>.toRecipeList(): List<RecipeDataModel> {
        return map { it.toRecipe() }
    }

    fun Recipe_Entity.toRecipe(): RecipeDataModel {
        val recipeDataBaseToDataMapper = RecipeDataBaseToDataMapper()
        return recipeDataBaseToDataMapper.toData(this)
    }

    companion object {
        val RECIPE_PAGINATION_PAGE_SIZE = 30
    }
}
