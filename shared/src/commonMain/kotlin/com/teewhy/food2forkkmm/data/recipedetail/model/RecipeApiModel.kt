package com.teewhy.food2forkkmm.data.recipedetail.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeApiModel(
    @SerialName("pk")
    val pk: Int,

    @SerialName("title")
    val title: String,

    @SerialName("publisher")
    val publisher: String,

    @SerialName("featured_image")
    val featuredImage: String,

    @SerialName("rating")
    val rating: Int = 0,

    @SerialName("source_url")
    val sourceUrl: String,

    @SerialName("ingredients")
    val ingredients: List<String> = emptyList(),

    @SerialName("long_date_added")
    val longDateAdded: Long,

    @SerialName("long_date_updated")
    val longDateUpdated: Long
)
