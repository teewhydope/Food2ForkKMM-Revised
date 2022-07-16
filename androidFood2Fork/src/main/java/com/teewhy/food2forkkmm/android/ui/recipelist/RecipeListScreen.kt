package com.teewhy.food2forkkmm.android.ui.recipelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teewhy.food2forkkmm.android.ui.recipelist.components.RecipeListItemView
import com.teewhy.food2forkkmm.android.ui.recipelist.components.SearchAppBar
import com.teewhy.food2forkkmm.android.ui.theme.Theme
import com.teewhy.food2forkkmm.presentation.recipelist.RecipeListViewModel
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategoryUtil

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeListScreen(onClickRecipeListItem: (Int) -> Unit) {
    val viewModel: RecipeListViewModel = viewModel()

    val state by viewModel.state.collectAsState()

    Theme(displayProgressBar = state.isLoading) {
        val foodCategories = remember { FoodCategoryUtil().getAllFoodCategories() }
        Scaffold(
            topBar = {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Recipe App",
                        style = MaterialTheme.typography.h1,
                        letterSpacing = (-1).sp
                    )
                    SearchAppBar(
                        query = state.query,
                        onQueryChanged = { viewModel.onUpdateQuery(it) },
                        onExecuteSearch = { viewModel.newSearch() },
                        categories = foodCategories,
                        selectedCategory = state.selectedCategory,
                        onSelectedCategoryChanged = { viewModel.onSelectCategory(it) }
                    )
                }
            }
        ) {
            LazyColumn(
                Modifier.fillMaxSize().background(MaterialTheme.colors.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(items = state.recipes) { index, recipe ->
                    RecipeListItemView(
                        recipe = recipe,
                        onClickRecipeListItem = onClickRecipeListItem
                    )
                }
            }
        }
    }
}
