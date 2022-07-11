package com.teewhy.food2forkkmm.data.local.mapper

import com.teewhy.food2forkkmm.base.BaseDataBaseToDataMapper
import com.teewhy.food2forkkmm.data.local.Recipe_Entity
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

class RecipeDataBaseToDataMapper : BaseDataBaseToDataMapper<Recipe_Entity, RecipeDataModel>() {
    override fun toData(model: Recipe_Entity): RecipeDataModel {
        return RecipeDataModel(
            id = model.id.toInt(),
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featured_image,
            rating = model.rating.toInt(),
            sourceUrl = model.source_url,
            ingredients = model.ingredients.convertIngredientsToList(),
            dateAdded = model.date_added.toLong(),
            dateUpdated = model.date_updated.toLong()
        )
    }
}

fun String.convertIngredientsToList(): List<String> {
    val list: ArrayList<String> = ArrayList()
    for (ingredient in split(",")) {
        list.add(ingredient)
    }
    return list
}
