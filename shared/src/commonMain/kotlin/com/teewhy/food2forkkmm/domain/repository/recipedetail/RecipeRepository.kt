package com.teewhy.food2forkkmm.domain.repository.recipedetail

import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel

interface RecipeRepository {
    suspend fun recipe(id: Int): RecipeDomainModel
}
