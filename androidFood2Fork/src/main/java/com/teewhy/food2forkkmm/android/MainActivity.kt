package com.teewhy.food2forkkmm.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.teewhy.food2forkkmm.android.ui.navigation.Navigation
import com.teewhy.food2forkkmm.network.NetworkClientFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val httpClient = NetworkClientFactory().build()

        setContent { Navigation() }
    }
}
