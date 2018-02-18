package com.lastserv.app.beer.remote

import com.lastserv.app.beer.data.mapper.BeerMapper
import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.remote.BeerService
import com.lastserv.app.beer.data.repository.BeerRemote
import com.lastserv.app.beer.domain.model.Beer

import io.reactivex.Single

import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BeerRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BeerRemoteImpl @Inject constructor(
            private val beerService: BeerService,
            private val entityMapper: BeerMapper) : BeerRemote {

    /**
     * Retrieve a list of [BeerEntity] instances from the [BeerService].
     */
    override fun getBeers(): Single<List<Beer>> {
        return beerService.getBeers()
                .map {
                    it.beers.map { listItem ->
                        entityMapper.mapFromEntity(listItem)
                    }
                }
    }

}