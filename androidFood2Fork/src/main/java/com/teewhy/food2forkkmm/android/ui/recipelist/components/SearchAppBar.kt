package com.teewhy.food2forkkmm.android.ui.recipelist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategory
import com.teewhy.food2forkkmm.presentation.recipelist.model.FoodCategoryUtil

@ExperimentalComposeUiApi
@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    categories: List<FoodCategory>,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged: (FoodCategory) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth().padding(bottom = 20.dp),
        color = MaterialTheme.colors.background,
        elevation = 0.dp
    ) {
        Column {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = query,
                onValueChange = { onQueryChanged(it) },
                label = { Text(text = "Search") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onExecuteSearch()
                        keyboardController?.hide()
                    }
                ),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
            )

            Spacer(Modifier.height(10.dp))

            LazyRow {
                items(categories) { category ->
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category,
                        onSelectedCategoryChanged = {
                            FoodCategoryUtil().getFoodCategory(it)?.let { newCategory ->
                                onSelectedCategoryChanged(newCategory)
                            }
                        }
                    )
                }
            }
        }
    }
}
