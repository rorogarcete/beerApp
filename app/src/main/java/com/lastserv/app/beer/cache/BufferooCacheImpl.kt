package com.lastserv.app.beer.cache

import com.lastserv.app.beer.cache.mapper.BeerEntityMapper
import com.lastserv.app.beer.cache.model.CachedBeer
import com.lastserv.app.beer.data.mapper.BeerMapper
import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.repository.BeerCache

import io.reactivex.Completable
import io.reactivex.Single

import io.realm.Realm
import io.realm.kotlin.where
import java.util.*

import javax.inject.Inject

/**
 * Cached implementation for retrieving and saving Bufferoo instances. This class implements the
 * [BeerCache] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BufferooCacheImpl @Inject constructor(realm: Realm,
                                            private val entityMapper: BeerEntityMapper,
                                            private val mapper: BeerMapper,
                                            private val preferencesHelper: PreferencesHelper):
        BeerCache {

    private val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    private var realm: Realm = Realm.getDefaultInstance()

    /**
     * Retrieve an instance from the database, used for tests
     */
    internal fun getRealm(): Realm {
        return realm
    }

    /**
     * Remove all the data from all the tables in the database.
     */
    override fun clearBeers(): Completable {
        return Completable.defer {
            realm.beginTransaction()
            try {
                realm.deleteAll()
            } finally {
                getRealm().commitTransaction()
            }
            Completable.complete()
        }
    }

    /**
     * Save the given list of [BeerEntity] instances to the database.
     */
    override fun saveBeers(beers: List<BeerEntity>): Completable {
        return Completable.defer {
            getRealm().beginTransaction()
            try {
                beers.forEach {
                    saveBufferoo(entityMapper.mapToCached(it))
                }
                getRealm().close()
            } finally {
                getRealm().commitTransaction()
            }
            Completable.complete()
        }
    }

    /**
     * Retrieve a list of [BeerEntity] instances from the database.
     */
    override fun getBeers(): Single<List<BeerEntity>> {
        val beers: List<BeerEntity> = Collections.emptyList()

        //return getRealm().where<CachedBeer>().findAll()

        return Single.defer<List<BeerEntity>> {
            //val updatesCursor = database.rawQuery(BufferooConstants.QUERY_GET_ALL_BUFFEROOS, null)

            //val beers = getRealm().where<CachedBeer>().findAll()
            //RealmResults<CachedBeer> beers : getRealm().where(CachedBeer)
//            val beersEntities: List<BeerEntity>

           //for (beer in beers)
                //val cachedBeer = getRealm().
                //beers.add(entityMapper.mapFromCached(cachedBeer))
//            }
//
//            updatesCursor.close()
            Single.just<List<BeerEntity>>(beers)
        }
    }

    /**
     * Helper method for saving a [CachedBeer] instance to the database.
     */
    private fun saveBufferoo(cachedBeer: CachedBeer) {
        getRealm().insert(cachedBeer)
    }

    /**
     * Checked whether there are instances of [CachedBeer] stored in the cache
     */
    override fun isCached(): Boolean {
        return getRealm().where<CachedBeer>().count() > 0
    }

    /**
     * Set a point in time at when the cache was last updated
     */
    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time
     */
    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

}