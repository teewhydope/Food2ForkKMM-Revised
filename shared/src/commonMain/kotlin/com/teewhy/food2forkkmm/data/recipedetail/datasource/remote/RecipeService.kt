package com.teewhy.food2forkkmm.data.recipedetail.datasource.remote

import com.teewhy.food2forkkmm.base.BaseApi.Companion.TOKEN
import com.teewhy.food2forkkmm.data.recipedetail.model.RecipeApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders

class RecipeService(
    private val httpClient: HttpClient,
    private val baseUrl: String
) {
    suspend fun recipe(
        id: Int
    ): RecipeApiModel {
        return httpClient.get(urlString = "$baseUrl/get") {
            url {
                parameters.append("id", id.toString())
            }
            headers {
                append(HttpHeaders.Accept, "application/json")
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Authorization, TOKEN)
            }
        }.body()
    }
}
