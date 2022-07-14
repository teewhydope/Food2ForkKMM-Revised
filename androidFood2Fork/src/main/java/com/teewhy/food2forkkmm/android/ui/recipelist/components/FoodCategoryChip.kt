package com.teewhy.food2forkkmm.android.ui.recipelist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.teewhy.food2forkkmm.android.ui.theme.RobotoTypography

@Composable
fun FoodCategoryChip(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategoryChanged: (String) -> Unit
) {
    Surface(
        modifier = Modifier.width(120.dp).padding(horizontal = 8.dp),
        shape = MaterialTheme.shapes.small,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectedCategoryChanged(category)
                    }
                )
        ) {
            Text(
                text = category,
                style = RobotoTypography.subtitle1,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth().padding(8.dp).align(Alignment.CenterVertically)
            )
        }
    }
}
