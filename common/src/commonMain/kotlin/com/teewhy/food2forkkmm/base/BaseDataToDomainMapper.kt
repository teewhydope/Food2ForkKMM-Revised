package com.teewhy.food2forkkmm.base

abstract class BaseDataToDomainMapper<DATA, DOMAIN> {
    abstract fun toDomain(model: DATA): DOMAIN
}
