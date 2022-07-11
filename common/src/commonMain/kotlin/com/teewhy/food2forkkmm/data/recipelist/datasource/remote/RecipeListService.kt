package com.teewhy.food2forkkmm.data.recipelist.datasource.remote

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseApi
import com.teewhy.food2forkkmm.data.recipelist.model.RecipeListApiModel
import com.teewhy.food2forkkmm.network.NetworkClientFactory.Companion.baseUrl
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders

@Injectable(Scope.BY_USE)
class RecipeListService(
    private val httpClient: HttpClient
) {
    suspend fun recipeList(
        page: Int,
        query: String
    ): RecipeListApiModel {
        return httpClient.get(urlString = "$baseUrl/search") {
            url {
                parameters.append("page", page.toString())
                parameters.append("query", query)
            }
            headers {
                append(HttpHeaders.Accept, "application/json")
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Authorization, BaseApi.TOKEN)
            }
        }.body()
    }

    companion object {
    }
}
