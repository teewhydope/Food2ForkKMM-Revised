package com.teewhy.food2forkkmm.android.ui.recipelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teewhy.food2forkkmm.presentation.recipelist.RecipeListViewModel

@Composable
fun RecipeListScreen(
    onSelectedRecipe: (Int) -> Unit,
    viewModel: RecipeListViewModel = viewModel()
) {
    val isLoading: Boolean by viewModel.isLoading.collectAsState()
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(count = viewModel.recipeList.value.size) {
                Text(text = viewModel.recipeList.value[it].title)
            }
        }
    }
}
