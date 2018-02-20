package com.lastserv.app.beer.cache.mapper

import com.lastserv.app.beer.cache.model.CachedBeer
import com.lastserv.app.beer.data.model.BeerEntity
import javax.inject.Inject

/**
 * Map a [CachedBeer] instance to and from a [BeerEntity] instance when data is moving between
 * this later and the Data layer
 */
class BeerEntityMapper @Inject constructor(): EntityMapper<CachedBeer, BeerEntity> {

    /**
     * Map a [BeerEntity] instance to a [CachedBeer] instance
     */
    override fun mapToCached(type: BeerEntity): CachedBeer {
        return CachedBeer(type.name, type.description, type.tagline, type.image_url)
    }

    /**
     * Map a [CachedBeer] instance to a [BeerEntity] instance
     */
    override fun mapFromCached(type: CachedBeer): BeerEntity {
        return BeerEntity(type.name, type.description, type.tagline, type.image_url)
    }

}