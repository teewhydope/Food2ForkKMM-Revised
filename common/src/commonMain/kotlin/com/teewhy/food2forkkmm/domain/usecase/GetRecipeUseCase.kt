package com.teewhy.food2forkkmm.domain.usecase

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseUseCase
import com.teewhy.food2forkkmm.base.UseCase
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipedetail.RecipeRepository
import kotlinx.coroutines.CoroutineScope

interface GetRecipeUseCase : UseCase<Int, RecipeDomainModel>

@Injectable(Scope.BY_USE)
class GetRecipeUseCaseImpl(
    private val recipeRepository: RecipeRepository
) : GetRecipeUseCase, BaseUseCase<Int, RecipeDomainModel>() {
    override suspend fun execute(
        request: Int,
        coroutineScope: CoroutineScope
    ) = recipeRepository.recipe(request)
}
