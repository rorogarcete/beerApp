package com.lastserv.app.beer.data.source

import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.repository.BeerCache
import com.lastserv.app.beer.data.repository.BeerDataStore

import io.reactivex.Completable
import io.reactivex.Single

import javax.inject.Inject

/**
 * Implementation of the [BeerDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class BeerCacheImpl @Inject constructor(private val beerCache: BeerCache) :
        BeerDataStore {

    /**
     * Clear all Beers from the cache
     */
    override fun clearBeers(): Completable {
        return beerCache.clearBeers()
    }

    /**
     * Save a given [List] of [BeerEntity] instances to the local database
     */
    override fun saveBeers(beers: List<BeerEntity>): Completable {
        return beerCache.saveBeers(beers)
                .doOnComplete {
                    beerCache.setLastCacheTime(System.currentTimeMillis())
                }
    }

    /**
     * Retrieve a list of [BeerEntity] instance from the cache
     */
    override fun getBeers(): Single<List<BeerEntity>> {
        return beerCache.getBeers()
    }
}