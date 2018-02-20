package com.lastserv.app.beer.ui.mapper

import com.lastserv.app.beer.presentation.model.BeerView
import com.lastserv.app.beer.ui.model.BeerViewModel
import javax.inject.Inject

/**
 * Map a [BeerViewModel] to and from a [Beer] instance when data is moving between
 * this layer and the Domain layer
 */
open class BeerMapper @Inject constructor(): Mapper<BeerViewModel, BeerView> {

    /**
     * Map a [Beer] instance to a [BeerViewModel] instance
     */
    override fun mapToViewModel(type: BeerView): BeerViewModel {
        return BeerViewModel(type.name, type.description, type.tagline, type.image_url)
    }


}