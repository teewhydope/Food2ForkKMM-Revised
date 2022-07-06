package com.teewhy.food2forkkmm.di.recipelist

import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository
import com.teewhy.food2forkkmm.domain.usecase.GetRecipeListUseCaseImpl
import dev.shustoff.dikt.Create
import dev.shustoff.dikt.UseConstructors

@UseConstructors(RecipeListDataModule::class)
class RecipeListDomainModule {

    private fun repository(): RecipeListRepository =
        RecipeListDataModule().providesRecipeListRepositoryImpl()

    @Create
    fun providesGetRecipeListUseCase(): GetRecipeListUseCaseImpl
}
