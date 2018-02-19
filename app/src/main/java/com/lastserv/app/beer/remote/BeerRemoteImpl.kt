package com.lastserv.app.beer.remote

import io.reactivex.Single
import com.lastserv.app.beer.data.model.BeerEntity
import com.lastserv.app.beer.data.repository.BeerRemote
import com.lastserv.app.beer.remote.mapper.BeerEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BeerRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BeerRemoteImpl @Inject constructor(
        private val beerService: BeerService,
        private val entityMapper: BeerEntityMapper) : BeerRemote {

    /**
     * Retrieve a list of [BeerEntity] instances from the [BeerService].
     */
    override fun getBeers(): Single<List<BeerEntity>> {
        return beerService.getBeers()
                .map {
                    it.beers.map { listItem ->
                        entityMapper.mapFromRemote(listItem)
                    }
                }
    }

}