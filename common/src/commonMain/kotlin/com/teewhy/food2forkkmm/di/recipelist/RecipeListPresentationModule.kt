package com.teewhy.food2forkkmm.di.recipelist

import com.teewhy.food2forkkmm.base.BaseUseCaseExecutor
import com.teewhy.food2forkkmm.presentation.recipelist.RecipeListViewModel
import dev.shustoff.dikt.Create
import dev.shustoff.dikt.UseModules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

@UseModules(RecipeListDomainModule::class)
class RecipeListPresentationModule {

    private val coroutineScope: CoroutineScope = CoroutineScope(Job())

    @Create
    fun providesUseCaseExecutor() = BaseUseCaseExecutor(coroutineScope)

    @Create
    fun providesRecipeListViewModel(): RecipeListViewModel
}
