package com.teewhy.food2forkkmm.domain.usecase

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseUseCase
import com.teewhy.food2forkkmm.base.UseCase
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository
import kotlinx.coroutines.CoroutineScope

interface GetRecipeListUseCase : UseCase<RecipeListRequestDomainModel, RecipeListDomainModel>

@Injectable(Scope.BY_USE)
class GetRecipeListUseCaseImpl(
    private val recipeListRepository: RecipeListRepository
) : GetRecipeListUseCase, BaseUseCase<RecipeListRequestDomainModel, RecipeListDomainModel>() {
    override suspend fun execute(
        request: RecipeListRequestDomainModel,
        coroutineScope: CoroutineScope
    ) = recipeListRepository.recipeList(request.page, request.query)
}
