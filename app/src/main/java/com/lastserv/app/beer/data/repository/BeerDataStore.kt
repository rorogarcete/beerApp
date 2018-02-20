package com.lastserv.app.beer.data.repository

import com.lastserv.app.beer.data.model.BeerEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the data operations.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface BeerDataStore {

    fun clearBeers(): Completable

    fun saveBeers(beers: List<BeerEntity>): Completable

    fun getBeers(): Single<List<BeerEntity>>

}