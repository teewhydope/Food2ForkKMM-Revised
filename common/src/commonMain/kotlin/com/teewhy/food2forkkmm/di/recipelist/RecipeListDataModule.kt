package com.teewhy.food2forkkmm.di.recipelist

import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeApiToDataMapper
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListRemoteDataSource
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListRemoteSource
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListService
import com.teewhy.food2forkkmm.data.recipelist.mapper.RecipeListApiToDataMapper
import com.teewhy.food2forkkmm.data.recipelist.repository.RecipeListRepositoryImpl
import com.teewhy.food2forkkmm.di.common.CommonModule
import com.teewhy.food2forkkmm.domain.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.mapper.RecipeListDataToDomainMapper
import dev.shustoff.dikt.Create
import dev.shustoff.dikt.CreateSingle
import dev.shustoff.dikt.UseModules

@UseModules(CommonModule::class)
class RecipeListDataModule(
    private val commonModule: CommonModule = CommonModule()
) {

    @Create
    fun providesRecipeListService(): RecipeListService

    @CreateSingle
    fun providesRecipeApiToDataMapper() = RecipeApiToDataMapper()

    @CreateSingle
    fun providesRecipeListApiToDataMapper() = RecipeListApiToDataMapper()

    @CreateSingle
    fun providesRecipeListRepositoryImpl(): RecipeListRepositoryImpl

    @CreateSingle
    private fun providesRecipeListRemoteDataSource(): RecipeListRemoteDataSource

    private fun remoteSource(): RecipeListRemoteSource = providesRecipeListRemoteDataSource()

    @CreateSingle
    fun providesRecipeDataToDomainMapper(): RecipeDataToDomainMapper

    @CreateSingle
    fun providesRecipeListDataToDomainMapper(): RecipeListDataToDomainMapper
}
