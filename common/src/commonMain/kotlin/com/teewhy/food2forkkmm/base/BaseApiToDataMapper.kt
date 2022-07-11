package com.teewhy.food2forkkmm.base

import cc.popkorn.annotations.Exclude

@Exclude
abstract class BaseApiToDataMapper<API, DATA> {
    abstract fun toData(model: API): DATA
}
