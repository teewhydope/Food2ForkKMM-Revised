package com.teewhy.food2forkkmm.data.local

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.squareup.sqldelight.db.SqlDriver

@Injectable(Scope.BY_NEW)
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
