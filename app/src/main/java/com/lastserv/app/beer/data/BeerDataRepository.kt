package com.lastserv.app.beer.data

import com.lastserv.app.beer.data.mapper.BeerMapper
import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.source.BeerDataStoreFactory
import com.lastserv.app.beer.data.source.BeerRemoteDataStore
import com.lastserv.app.beer.domain.model.Beer
import com.lastserv.app.beer.domain.repository.BeerRepository

import io.reactivex.Completable
import io.reactivex.Single

import javax.inject.Inject

/**
 * Provides an implementation of the [BeerDataRepository] interface for communicating to and from
 * data sources
 */
class BeerDataRepository @Inject constructor(
                        private val factory: BeerDataStoreFactory,
                        private val beerMapper: BeerMapper): BeerRepository {

    override fun clearBeers(): Completable {
        return factory.retrieveCacheDataStore().clearBeers()
    }

    override fun saveBeers(beers: List<Beer>): Completable {
        val beerEntities = beers.map { beerMapper.mapToEntity(it) }
        return saveBeerEntities(beerEntities)
    }

    private fun saveBeerEntities(beers: List<BeerEntity>): Completable {
        return factory.retrieveCacheDataStore().saveBeers(beers)
    }

    override fun getBeers(): Single<List<Beer>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getBeers()
                .flatMap {
                    if (dataStore is BeerRemoteDataStore) {
                        saveBeerEntities(it).toSingle { it }
                    } else {
                        Single.just(it)
                    }
                }
                .map { list ->
                    list.map { listItem ->
                        beerMapper.mapFromEntity(listItem)
                    }
                }
    }

}