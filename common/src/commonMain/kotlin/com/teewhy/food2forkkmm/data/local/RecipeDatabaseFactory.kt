package com.teewhy.food2forkkmm.data.local

import com.squareup.sqldelight.db.SqlDriver

class RecipeDatabaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createDatabase(): RecipeDataBase {
        return RecipeDataBase(driverFactory.createDriver())
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}
