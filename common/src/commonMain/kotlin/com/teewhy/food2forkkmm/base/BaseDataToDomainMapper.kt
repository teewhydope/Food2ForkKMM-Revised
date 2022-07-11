package com.teewhy.food2forkkmm.base

import cc.popkorn.annotations.Exclude

@Exclude
abstract class BaseDataToDomainMapper<DATA, DOMAIN> {
    abstract fun toDomain(model: DATA): DOMAIN
}
