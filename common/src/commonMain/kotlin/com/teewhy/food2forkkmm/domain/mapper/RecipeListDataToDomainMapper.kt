package com.teewhy.food2forkkmm.domain.mapper

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import com.teewhy.food2forkkmm.base.BaseDataToDomainMapper
import com.teewhy.food2forkkmm.domain.mapper.RecipeListDataToDomainMapper.MapperInput
import com.teewhy.food2forkkmm.domain.model.RecipeDomainModel
import com.teewhy.food2forkkmm.domain.model.RecipeListDomainModel

@Injectable(Scope.BY_NEW)
class RecipeListDataToDomainMapper : BaseDataToDomainMapper<MapperInput, RecipeListDomainModel>() {
    override fun toDomain(model: MapperInput): RecipeListDomainModel {
        return RecipeListDomainModel(
            count = model.count,
            results = model.results
        )
    }

    data class MapperInput(
        val count: Int,
        val results: Collection<RecipeDomainModel>
    )
}
