package com.teewhy.food2forkkmm.presentation.recipelist

import com.teewhy.food2forkkmm.di.recipelist.RecipeListDomainModule
import com.teewhy.food2forkkmm.di.recipelist.RecipeListPresentationModule
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.presentation.recipedetail.mapper.RecipeDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper.MapperInput
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RecipeListViewModel : ViewModel() {
    private val recipeListPresentationDi = RecipeListPresentationModule()
    private val recipeListDomainDi = RecipeListDomainModule()
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
        recipeListPresentationDi.providesUseCaseExecutor().execute(
            useCase = recipeListDomainDi.providesGetRecipeListUseCase(),
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
