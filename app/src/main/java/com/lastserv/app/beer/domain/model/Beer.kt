package com.lastserv.app.beer.domain.model

/**
 * Representation for a [Beer] fetched from an external layer data source
 */
data class Beer(val name: String, val description: String, val tagline: String, val image: String)