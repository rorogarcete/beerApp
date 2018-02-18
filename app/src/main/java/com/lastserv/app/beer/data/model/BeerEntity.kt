package com.lastserv.app.beer.data.model

/**
 * Representation for a [BeerEntity] fetched from an external layer data source
 */
data class BeerEntity(val name: String, val description: String, val tagline: String, val image: String)