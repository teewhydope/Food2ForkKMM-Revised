package com.teewhy.food2forkkmm.domain.usecase

import com.teewhy.food2forkkmm.base.BaseUseCase
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipedetail.RecipeRepository
import kotlinx.coroutines.CoroutineScope

class GetRecipeUseCase(
    private val recipeRepository: RecipeRepository
) : BaseUseCase<Int, RecipeDomainModel>() {
    override suspend fun execute(
        request: Int,
        coroutineScope: CoroutineScope
    ) = recipeRepository.recipe(request)
}
