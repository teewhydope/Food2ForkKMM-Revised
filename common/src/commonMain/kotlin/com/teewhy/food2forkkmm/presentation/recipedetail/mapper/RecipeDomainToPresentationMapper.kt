package com.teewhy.food2forkkmm.presentation.recipedetail.mapper

import com.teewhy.food2forkkmm.base.BaseDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel

class RecipeDomainToPresentationMapper :
    BaseDataToDomainMapper<RecipeDomainModel, RecipePresentationModel>() {
    override fun toDomain(model: RecipeDomainModel): RecipePresentationModel {
        return RecipePresentationModel(
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
