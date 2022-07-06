package com.teewhy.food2forkkmm.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(RecipeDataBase.Schema, "recipes.db")
    }
}
