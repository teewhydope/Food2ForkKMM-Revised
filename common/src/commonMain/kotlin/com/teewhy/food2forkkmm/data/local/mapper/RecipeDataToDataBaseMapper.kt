package com.teewhy.food2forkkmm.data.local.mapper

import com.teewhy.food2forkkmm.base.BaseDataToDataBaseMapper
import com.teewhy.food2forkkmm.data.local.RecipeDataBase
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeDataModel

class RecipeDataToDataBaseMapper(
    private var queries: RecipeDataBase
) : BaseDataToDataBaseMapper<RecipeDataModel, Unit>() {
    override fun toDataBase(model: RecipeDataModel) {
        return queries.recipeDbQueries.insertRecipe(
            id = model.id.toLong(),
            title = model.title,
            publisher = model.publisher,
            featured_image = model.featuredImage,
            rating = model.rating.toLong(),
            source_url = model.sourceUrl,
            ingredients = model.ingredients.convertIngredientListToString(),
            date_updated = model.dateUpdated.toDouble(),
            date_added = model.dateAdded.toDouble()
        )
    }
}

/**
 * "Carrot, potato, Chicken, ..."
 */
fun List<String>.convertIngredientListToString(): String {
    val ingredientsString = StringBuilder()
    for (ingredient in this) {
        ingredientsString.append("$ingredient,")
    }
    return ingredientsString.toString()
}
