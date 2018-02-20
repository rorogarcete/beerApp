package com.lastserv.app.beer.data.source

import com.lastserv.app.beer.data.repository.BeerCache
import com.lastserv.app.beer.data.repository.BeerDataStore

import javax.inject.Inject

/**
 * Create an instance of a BeerDataStore
 */
open class BeerDataStoreFactory @Inject constructor(
        private val beerCache: BeerCache,
        private val beerCacheDataStore: BeerCacheDataStore,
        private val beerRemoteDataStore: BeerRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): BeerDataStore {
        if (beerCache.isCached() && !beerCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveCacheDataStore(): BeerDataStore {
        return beerCacheDataStore
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveRemoteDataStore(): BeerDataStore {
        return beerRemoteDataStore
    }

}