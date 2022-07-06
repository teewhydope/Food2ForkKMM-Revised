package com.teewhy.food2forkkmm.presentation.recipedetail.model

data class RecipePresentationModel(
    val id: Int,
    val title: String,
    val publisher: String,
    val featuredImage: String,
    val rating: Int,
    val sourceUrl: String,
    val ingredients: List<String> = listOf(),
    val dateAdded: Long,
    val dateUpdated: Long
)
