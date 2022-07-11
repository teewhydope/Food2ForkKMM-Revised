package com.teewhy.food2forkkmm.base

import cc.popkorn.annotations.Exclude

@Exclude
abstract class BaseDataBaseToDataMapper<DB, DATA> {
    abstract fun toData(model: DB): DATA
}
