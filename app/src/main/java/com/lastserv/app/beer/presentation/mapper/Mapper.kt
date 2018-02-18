package com.lastserv.app.beer.presentation.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}