package com.lastserv.app.beer.domain.repository

import com.lastserv.app.beer.domain.model.Beer
import com.lastserv.app.beer.domain.model.BeerFavorite
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface BeerRepository {

    fun clearBeers(): Completable

    fun saveBeers(beers: List<Beer>): Completable

    fun getBeers(): Single<List<Beer>>

//    fun getFavorites(): Single<List<BeerFavorite>>
//
//    fun saveFavorite(beerFavorite: BeerFavorite): Completable

}