package com.teewhy.food2forkkmm.presentation.recipelist.model

import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.BEEF
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.CHICKEN
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.DESSERT
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.DONUT
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.ERROR
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.MILK
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.PIZZA
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.SOUP
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.VEGAN
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory.VEGETARIAN

class FoodCategoryUtil {
    fun getAllFoodCategories(): List<FoodCategory> {
        return listOf(
            ERROR,
            CHICKEN,
            BEEF,
            SOUP,
            DESSERT,
            VEGETARIAN,
            MILK,
            VEGAN,
            PIZZA,
            DONUT
        )
    }

    fun getFoodCategory(value: String): FoodCategory? {
        val map = FoodCategory.values().associateBy(FoodCategory::value)
        return map[value]
    }
}
