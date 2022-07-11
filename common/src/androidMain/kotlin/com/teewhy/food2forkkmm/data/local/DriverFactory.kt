package com.teewhy.food2forkkmm.data.local

import android.content.Context
import cc.popkorn.annotations.Injectable
import cc.popkorn.inject
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

@Injectable
actual class DriverFactory {
    private val context = inject<Context>()
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            RecipeDataBase.Schema,
            context,
            "recipes.db"
        )
    }
}
