package com.lastserv.app.beer.remote.mapper

import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.remote.model.BeerModel

import javax.inject.Inject

/**
 * Map a [BeerModel] to and from a [BeerEntity] instance when data is moving between
 * this later and the Data layer
 */
open class BeerEntityMapper @Inject constructor(): EntityMapper<BeerModel, BeerEntity> {

    /**
     * Map an instance of a [BufferooModel] to a [BufferooEntity] model
     */
    override fun mapFromRemote(type: BeerModel): BeerEntity {
        return BeerEntity(type.name, type.description, type.tagline, type.image)
    }

}