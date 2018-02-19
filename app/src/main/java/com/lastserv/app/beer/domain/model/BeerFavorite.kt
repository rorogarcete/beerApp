package com.lastserv.app.beer.domain.model

/**
 * Representation for a [BeerFavorite] fetched from an external layer data source
 */
data class BeerFavorite(val name: String, val description: String, val tagline: String, val image: String)