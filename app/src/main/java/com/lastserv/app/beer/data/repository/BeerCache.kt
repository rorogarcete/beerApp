package com.lastserv.app.beer.data.repository

import com.lastserv.app.beer.data.model.BeerEntity

import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the caching of Beers. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface BeerCache {

    /**
     * Clear all beers from the cache
     */
    fun clearBeers(): Completable

    /**
     * Save a given list of beers to the cache
     */
    fun saveBeers(beers: List<BeerEntity>): Completable

    /**
     * Retrieve a list of Beers, from the cache
     */
    fun getBeers(): Single<List<BeerEntity>>

    /**
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * @param lastCache The last cache.
     * Set last cache time
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Checks if the cache is expired.
     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean

}