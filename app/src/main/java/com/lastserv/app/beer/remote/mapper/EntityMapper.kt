package com.lastserv.app.beer.remote.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 */
interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}