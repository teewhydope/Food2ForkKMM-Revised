package com.teewhy.food2forkkmm.data.recipelist.model

import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeApiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeListApiModel(
    @SerialName("count")
    var count: Int,

    @SerialName("results")
    var results: Collection<RecipeApiModel>
)
