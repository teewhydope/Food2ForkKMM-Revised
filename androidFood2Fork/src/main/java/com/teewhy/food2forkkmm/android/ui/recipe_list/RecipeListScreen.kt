package com.teewhy.food2forkkmm.android.ui.recipe_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun RecipeListScreen(
    onSelectedRecipe: (Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(count = 100) { index ->
            ClickableText(
                text = AnnotatedString("RecipeListScreen $index"),
                onClick = { onSelectedRecipe(index) },
                modifier = Modifier.fillMaxWidth().padding(20.dp)
            )
        }
    }
}
