package com.teewhy.food2forkkmm.presentation.recipelist.mapper

import com.teewhy.food2forkkmm.base.BaseDataToDomainMapper
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel
import com.teewhy.food2forkkmm.presentation.recipelist.mapper.RecipeListDomainToPresentationMapper.MapperInput
import com.teewhy.food2forkkmm.presentation.recipelist.model.RecipeListPresentationModel

class RecipeListDomainToPresentationMapper :
    BaseDataToDomainMapper<MapperInput, RecipeListPresentationModel>() {
    override fun toDomain(model: MapperInput): RecipeListPresentationModel {
        return RecipeListPresentationModel(
            count = model.count,
            results = model.results
        )
    }

    data class MapperInput(
        val count: Int,
        val results: List<RecipePresentationModel>
    )
}
