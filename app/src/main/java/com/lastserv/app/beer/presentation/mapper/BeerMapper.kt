package com.lastserv.app.beer.presentation.mapper

import com.lastserv.app.beer.domain.model.Beer
import com.lastserv.app.beer.presentation.model.BeerView
import javax.inject.Inject

/**
 * Map a [BeerView] to and from a [Beer] instance when data is moving between
 * this layer and the Domain layer
 */
open class BeerMapper @Inject constructor(): Mapper<BeerView, Beer> {

    /**
     * Map a [Beer] instance to a [BeerView] instance
     */
    override fun mapToView(type: Beer): BeerView {
        return BeerView(type.name, type.description, type.tagline, type.image_url)
    }

}