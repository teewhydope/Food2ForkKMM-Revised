package com.teewhy.food2forkkmm.data.recipedetail.mapper

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseApiToDataMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeApiModel
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

@Injectable(Scope.BY_NEW)
class RecipeApiToDataMapper : BaseApiToDataMapper<RecipeApiModel, RecipeDataModel>() {
    override fun toData(model: RecipeApiModel): RecipeDataModel {
        return RecipeDataModel(
            id = model.pk,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients,
            dateAdded = model.longDateAdded,
            dateUpdated = model.longDateUpdated
        )
    }
}
