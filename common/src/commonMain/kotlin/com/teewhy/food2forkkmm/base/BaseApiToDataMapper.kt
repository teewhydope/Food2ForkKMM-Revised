package com.teewhy.food2forkkmm.base

abstract class BaseApiToDataMapper<API, DATA> {
    abstract fun toData(model: API): DATA
}
