package com.teewhy.food2forkkmm.base

import cc.popkorn.annotations.Exclude

@Exclude
abstract class BaseDataToDataBaseMapper<DATA, DB> {
    abstract fun toDataBase(model: DATA): DB
}
