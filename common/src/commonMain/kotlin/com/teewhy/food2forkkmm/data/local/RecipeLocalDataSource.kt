package com.teewhy.food2forkkmm.data.local

import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

interface RecipeLocalDataSource {

    fun insert(recipe: RecipeDataModel)

    fun insert(recipes: List<RecipeDataModel>)

    fun search(query: String, page: Int): List<RecipeDataModel>

    fun getAll(page: Int): List<RecipeDataModel>

    fun get(recipeId: Int): RecipeDataModel
}
