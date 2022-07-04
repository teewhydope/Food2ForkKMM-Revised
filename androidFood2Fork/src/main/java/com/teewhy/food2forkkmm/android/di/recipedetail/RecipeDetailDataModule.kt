package com.teewhy.food2forkkmm.android.di.recipedetail

import com.teewhy.food2forkkmm.data.recipedetail.mapper.RecipeApiToDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RecipeDetailDataModule {

    @Provides
    fun providesRecipeApiToDataMapper() = RecipeApiToDataMapper()
}
