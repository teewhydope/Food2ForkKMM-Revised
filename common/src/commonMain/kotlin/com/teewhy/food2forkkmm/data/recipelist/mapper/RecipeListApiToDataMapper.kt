package com.teewhy.food2forkkmm.data.recipelist.mapper

import com.teewhy.food2forkkmm.base.BaseApiToDataMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.data.recipelist.mapper.RecipeListApiToDataMapper.MapperInput
import com.teewhy.food2forkkmm.data.recipelist.model.RecipeListDataModel

class RecipeListApiToDataMapper : BaseApiToDataMapper<MapperInput, RecipeListDataModel>() {
    override fun toData(model: MapperInput): RecipeListDataModel {
        return RecipeListDataModel(
            count = model.count,
            results = model.results
        )
    }

    data class MapperInput(
        val count: Int,
        val results: Collection<RecipeDataModel>
    )
}
