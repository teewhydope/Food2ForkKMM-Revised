package com.teewhy.food2forkkmm.presentation.recipelist

import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RecipeListViewModel : ViewModel() {
    val textValue: MutableStateFlow<String> = MutableStateFlow("").cMutableStateFlow()

    init {
        // Test String
        textValue.value = "Hello World! ViewModel Works"
    }
}
