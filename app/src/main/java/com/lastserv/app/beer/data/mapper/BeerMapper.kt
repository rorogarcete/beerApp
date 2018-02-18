package com.lastserv.app.beer.data.mapper

import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.domain.model.Beer

import javax.inject.Inject


/**
 * Map a [BeerEntity] to and from a [Beer] instance when data is moving between
 * this layer and the Domain layer
 */
open class BeerMapper @Inject constructor(): Mapper<BeerEntity, Beer> {

    /**
     * Map a [BeerEntity] instance to a [Beer] instance
     */
    override fun mapFromEntity(type: BeerEntity): Beer {
        return Beer(type.name, type.description, type.tagline, type.image)
    }

    /**
     * Map a [Beer] instance to a [BeerEntity] instance
     */
    override fun mapToEntity(type: Beer): BeerEntity {
        return BeerEntity(type.name, type.description, type.tagline, type.image)
    }


}