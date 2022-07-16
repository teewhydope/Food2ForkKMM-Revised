package com.teewhy.food2forkkmm.android.ui.recipedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.teewhy.food2forkkmm.presentation.recipedetail.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    recipeId: Int?
) {
    val viewModel: RecipeDetailViewModel = viewModel()

    LaunchedEffect(Unit) {
        recipeId?.let { viewModel.fetchSingleRecipe(it) }
    }
    val recipeList by viewModel.recipe.collectAsState()

    val painter = rememberAsyncImagePainter(recipeList.featuredImage)

    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}
