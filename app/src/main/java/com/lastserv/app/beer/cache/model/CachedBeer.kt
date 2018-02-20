package com.lastserv.app.beer.cache.model

import io.realm.RealmObject

/**
 * Model used solely for the caching of a beer
 */
open class CachedBeer(
        open var name: String = "",
        open var description: String = "",
        open var tagline: String = "",
        open var image_url: String = "") : RealmObject()