package com.lastserv.app.beer.remote

import com.lastserv.app.beer.remote.model.BeerModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the Punk API
 */
interface BeerService {

    @GET("beers")
    fun getBeers(): Single<BeerResponse>

    class BeerResponse {
        lateinit var beers: List<BeerModel>
    }

}
