package com.teewhy.food2forkkmm.presentation.recipedetail

import cc.popkorn.inject
import com.teewhy.food2forkkmm.base.BaseUseCaseExecutor
import com.teewhy.food2forkkmm.domain.usecase.GetRecipeUseCase
import com.teewhy.food2forkkmm.presentation.recipedetail.mapper.RecipeDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RecipeDetailViewModel : ViewModel() {
    private val useCaseExecutor = inject<BaseUseCaseExecutor>()
    private val getRecipeUseCase = inject<GetRecipeUseCase>()
    private val recipeDomainToPresentationMapper = RecipeDomainToPresentationMapper()

    private val _recipe: MutableStateFlow<RecipePresentationModel> =
        MutableStateFlow(RecipePresentationModel())
    val recipe: CStateFlow<RecipePresentationModel> = _recipe.cStateFlow()

    fun getRecipe(recipeId: Int) {
        useCaseExecutor.execute(
            useCase = getRecipeUseCase,
            value = recipeId,
            callback = { domainModel ->
                _recipe.value = recipeDomainToPresentationMapper.toDomain(domainModel)
            },
            error =
            {}
        )
    }
}
