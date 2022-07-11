package com.teewhy.food2forkkmm.domain.mapper

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseDataToDomainMapper
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel

@Injectable(Scope.BY_NEW)
class RecipeDataToDomainMapper : BaseDataToDomainMapper<RecipeDataModel, RecipeDomainModel>() {
    override fun toDomain(model: RecipeDataModel): RecipeDomainModel {
        return RecipeDomainModel(
            id = model.id,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated
        )
    }
}
