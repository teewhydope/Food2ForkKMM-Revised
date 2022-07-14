package com.teewhy.food2forkkmm.presentation.recipedetail.model

data class RecipePresentationModel(
    val id: Int = -1,
    val title: String = "",
    val publisher: String = "",
    val featuredImage: String = "",
    val rating: Int = 0,
    val sourceUrl: String = "",
    val ingredients: List<String> = listOf(),
    val dateAdded: Long = 0L,
    val dateUpdated: Long = 0L
)
