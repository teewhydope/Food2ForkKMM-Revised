package com.teewhy.food2forkkmm.android.ui.recipe_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teewhy.food2forkkmm.presentation.recipelist.RecipeListViewModel

@Composable
fun RecipeListScreen(
    onSelectedRecipe: (Int) -> Unit,
    viewModel: RecipeListViewModel = viewModel(),
) {
    val text: String by viewModel.textValue.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
    }
}
