package com.teewhy.food2forkkmm.domain.model

data class RecipeListDomainModel(
    val count: Int,
    val results: Collection<RecipeDomainModel>
)
