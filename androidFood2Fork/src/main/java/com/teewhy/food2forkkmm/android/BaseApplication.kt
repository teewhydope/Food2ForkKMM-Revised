package com.teewhy.food2forkkmm.android

import android.app.Application
import android.content.Context
import cc.popkorn.popKorn
import com.teewhy.food2forkkmm.base.Logger

val logger = Logger("AppDebug")

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        popKorn().addInjectable(this, Context::class)
    }
}
