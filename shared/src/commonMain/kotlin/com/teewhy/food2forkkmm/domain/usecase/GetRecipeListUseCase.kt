package com.teewhy.food2forkkmm.domain.usecase

import com.teewhy.food2forkkmm.base.BaseUseCase
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository
import kotlinx.coroutines.CoroutineScope

class GetRecipeListUseCase(
    private val recipeListRepository: RecipeListRepository
) : BaseUseCase<RecipeListRequestDomainModel, RecipeListDomainModel> {
    override suspend fun execute(
        request: RecipeListRequestDomainModel,
        coroutineScope: CoroutineScope
    ) = recipeListRepository.recipeList(request.page, request.query)
}
