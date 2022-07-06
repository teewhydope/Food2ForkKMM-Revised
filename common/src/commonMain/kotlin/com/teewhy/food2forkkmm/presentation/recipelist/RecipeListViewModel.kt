package com.teewhy.food2forkkmm.presentation.recipelist

import com.teewhy.food2forkkmm.di.recipedetail.RecipeDetailPresentationModule
import com.teewhy.food2forkkmm.di.recipelist.RecipeListDomainModule
import com.teewhy.food2forkkmm.di.recipelist.RecipeListPresentationModule
import com.teewhy.food2forkkmm.domain.model.RecipeListRequestDomainModel
import com.teewhy.food2forkkmm.presentation.recipedetail.mapper.RecipeDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper.MapperInput
import dev.icerock.moko.mvvm.flow.CMutableStateFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RecipeListViewModel : ViewModel() {
    private val recipeListPresentationDi = RecipeListPresentationModule()
    private val recipeListDomainDi = RecipeListDomainModule()
    private val recipeDetailPresentationDi = RecipeDetailPresentationModule()

    val textValue: CMutableStateFlow<String> = MutableStateFlow("").cMutableStateFlow()
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
                val res = domainModel.results
                val mapper1 = RecipeDomainToPresentationMapper()
                val mapper2 = RecipeListDomainToPresentationMapper()

                val results = res.map { index ->
                    mapper1.toDomain(index)
                }

                val mapper = mapper2.toDomain(
                    MapperInput(
                        domainModel.count,
                        results
                    )
                )
                _recipeList.value = mapper.results.toList()
                textValue.value = mapper.results.toList()[0].publisher
                _isLoading.value = false
            },
            error = {}
        )
    }
}
