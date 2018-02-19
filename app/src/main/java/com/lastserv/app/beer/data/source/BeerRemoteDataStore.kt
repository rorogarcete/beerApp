package com.lastserv.app.beer.data.source

import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.repository.BeerDataStore
import com.lastserv.app.beer.data.repository.BeerRemote
import io.reactivex.Completable
import io.reactivex.Single

import javax.inject.Inject

/**
 * Implementation of the [BeerDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class BeerRemoteDataStore @Inject constructor(private val beerRemote: BeerRemote) :
        BeerDataStore {

    override fun clearBeers(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBeers(beers: List<BeerEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BeerEntity] instances from the API
     */
    override fun getBeers(): Single<List<BeerEntity>> {
        return beerRemote.getBeers()
    }

}