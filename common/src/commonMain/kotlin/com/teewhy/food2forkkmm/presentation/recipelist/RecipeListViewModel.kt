package com.teewhy.food2forkkmm.presentation.recipelist

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import cc.popkorn.inject
import com.teewhy.food2forkkmm.base.BaseUseCaseExecutor
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.domain.usecase.GetRecipeListUseCase
import com.teewhy.food2forkkmm.presentation.recipedetail.mapper.RecipeDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper.MapperInput
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Injectable(Scope.BY_NEW)
class RecipeListViewModel : ViewModel() {
    private val useCaseExecutor = inject<BaseUseCaseExecutor>()
    private val getRecipeListUseCase = inject<GetRecipeListUseCase>()
    private val recipeDomainToPresentationMapper = RecipeDomainToPresentationMapper()
    private val recipeListDomainToPresentationMapper = RecipeListDomainToPresentationMapper()

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: CStateFlow<Boolean> = _isLoading.cStateFlow()

    private val _recipeList: MutableStateFlow<List<RecipePresentationModel>> =
        MutableStateFlow(listOf())
    val recipeList: CStateFlow<List<RecipePresentationModel>> = _recipeList.cStateFlow()

    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        _isLoading.value = true
        useCaseExecutor.execute(
            useCase = getRecipeListUseCase,
            value = RecipeListRequestDomainModel(
                page = 1,
                query = ""
            ),
            callback = { domainModel ->

                val recipeList = recipeListDomainToPresentationMapper.toDomain(
                    MapperInput(
                        domainModel.count,
                        domainModel.results.map { index ->
                            recipeDomainToPresentationMapper.toDomain(index)
                        }
                    )
                )

                _recipeList.value = recipeList.results.toList()
                _isLoading.value = false
            },
            error = {}
        )
    }
}
