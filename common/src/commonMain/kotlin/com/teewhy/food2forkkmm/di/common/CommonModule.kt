package com.teewhy.food2forkkmm.di.common

import com.teewhy.food2forkkmm.base.BaseApi
import com.teewhy.food2forkkmm.network.NetworkClientFactory

class CommonModule {
    val client by lazy {
        NetworkClientFactory().build()
    }

    val baseUrl = BaseApi.BASE_URL
}
