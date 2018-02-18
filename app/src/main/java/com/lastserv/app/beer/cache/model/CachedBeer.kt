package com.lastserv.app.beer.cache.model

import io.realm.RealmObject

/**
 * Model used solely for the caching of a beer
 */
open class CachedBeer constructor(val name: String, val description: String,
                      val tagline: String, val image: String) : RealmObject()