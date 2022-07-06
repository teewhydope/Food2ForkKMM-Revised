package com.teewhy.food2forkkmm.domain.repository.recipelist

import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel

interface RecipeListRepository {
    suspend fun recipeList(page: Int, query: String): RecipeListDomainModel
}
