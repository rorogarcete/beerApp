package com.lastserv.app.beer.data.repository

import com.lastserv.app.beer.data.model.BeerEntity

import io.reactivex.Single

/**
 * Interface defining methods for the remote datasource.
 */
interface BeerRemote {

    /**
     * Retrieve a list of Beers from remote
     */
    fun getBeers(): Single<List<BeerEntity>>

}