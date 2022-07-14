package com.teewhy.food2forkkmm.android.ui.recipelist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.teewhy.food2forkkmm.android.ui.theme.RobotoTypography
import com.teewhy.food2forkkmm.android.ui.theme.paleRed
import com.teewhy.food2forkkmm.presentation.recipedetail.model.RecipePresentationModel

@Composable
fun RecipeListItemView(
    recipe: RecipePresentationModel,
    onClickRecipeListItem: (Int) -> Unit
) {
    val painter = rememberAsyncImagePainter(recipe.featuredImage)

    Row(Modifier.fillMaxWidth().background(MaterialTheme.colors.background).padding(16.dp).height(96.dp)) {
        Card(
            Modifier.padding(end = 16.dp),
            shape = MaterialTheme.shapes.large,
            elevation = 0.dp
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .width(96.dp)
                        .height(96.dp),
                    painter = painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            Modifier.fillMaxSize().padding(bottom = 6.dp)
                .clickable { onClickRecipeListItem(recipe.id) },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.h2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Publisher: ${recipe.publisher}",
                style = RobotoTypography.subtitle2
            )
            Box(
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .align(Alignment.End).background(paleRed)
            ) {
                Text(
                    text = "${recipe.rating} stars",
                    style = RobotoTypography.caption,
                    modifier = Modifier.padding(6.dp)
                )
            }
        }
    }
}
