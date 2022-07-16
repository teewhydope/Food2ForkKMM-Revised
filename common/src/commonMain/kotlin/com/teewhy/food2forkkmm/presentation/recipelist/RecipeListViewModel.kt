package com.teewhy.food2forkkmm.presentation.recipelist

import cc.popkorn.inject
import com.teewhy.food2forkkmm.base.BaseUseCaseExecutor
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.domain.usecase.GetRecipeListUseCase
import com.teewhy.food2forkkmm.presentation.recipedetail.mapper.RecipeDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper.MapperInput
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory
import com.teewhy.food2forkkmm.presentation.recipelist.model.RecipeListState
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RecipeListViewModel : ViewModel() {
    private val useCaseExecutor = inject<BaseUseCaseExecutor>()
    private val getRecipeListUseCase = inject<GetRecipeListUseCase>()
    private val recipeDomainToPresentationMapper = RecipeDomainToPresentationMapper()
    private val recipeListDomainToPresentationMapper = RecipeListDomainToPresentationMapper()

    private val _state: MutableStateFlow<RecipeListState> = MutableStateFlow(RecipeListState())
    val state: CStateFlow<RecipeListState> = _state.cStateFlow()

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        _state.value = state.value.copy(isLoading = true)
        useCaseExecutor.execute(
            useCase = getRecipeListUseCase,
            value = RecipeListRequestDomainModel(
                page = _state.value.page,
                query = _state.value.query
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
                _state.value = state.value.copy(recipes = recipeList.results.toList())
                _state.value = state.value.copy(isLoading = false)
            },
            error = {}
        )
    }

    /**
     * Perform a new search:
     * 1. page = 1
     * 2. list position needs to be reset
     */
    fun newSearch() {
        _state.value = state.value.copy(page = 1, recipes = listOf())
        fetchRecipes()
    }

    /**
     *  Called when a new FoodCategory chip is selected
     */
    fun onSelectCategory(category: FoodCategory) {
        if (_state.value.selectedCategory == category) {
            return
        }
        _state.value = _state.value.copy(selectedCategory = category, query = category.value)
        newSearch()
    }

    fun onUpdateQuery(query: String) {
        _state.value = _state.value.copy(query = query, selectedCategory = null)
    }
}
