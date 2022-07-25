package com.teewhy.food2forkkmm.data.recipelist.repository

import cc.popkorn.annotations.Exclude
import com.teewhy.food2forkkmm.data.local.RecipeLocalDataSource
import com.teewhy.food2forkkmm.data.recipelist.datasource.remote.RecipeListRemoteSource
import com.teewhy.food2forkkmm.domain.mapper.RecipeDataToDomainMapper
import com.teewhy.food2forkkmm.domain.mapper.RecipeListDataToDomainMapper
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel
import com.teewhy.food2forkkmm.domain.repository.recipelist.RecipeListRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

val expectedResult = RecipeListDomainModel(
    count = 1,
    results = listOf()
)

@Exclude
@RunWith(MockitoJUnitRunner::class)
class RecipeListRepositoryImplTest {

    @Mock
    private lateinit var recipeListRemoteSource: RecipeListRemoteSource

    @Mock
    private lateinit var recipeLocalDataSource: RecipeLocalDataSource

    @Mock
    private lateinit var recipeDataToDomainMapper: RecipeDataToDomainMapper

    @Mock
    private lateinit var recipeListDataToDomainMapper: RecipeListDataToDomainMapper

    private lateinit var test: RecipeListRepository

    @Before
    fun setup() {
        test = RecipeListRepositoryImpl(
            recipeListRemoteSource,
            recipeLocalDataSource,
            recipeDataToDomainMapper,
            recipeListDataToDomainMapper
        )
    }

    @Test
    fun `Given page number and query, When recipeList Then returns recipe Lists`() {
        val pageNumber = 2
        val query = ""

        // When
        runBlocking {
            val actualResult = test.recipeList(pageNumber, query)

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }
}
