package com.example.composepaging3caching.data.mappers

import com.example.composepaging3caching.data.local.BeerEntity
import com.example.composepaging3caching.data.remot.BeerResponse
import com.example.composepaging3caching.domain.Beer


fun BeerResponse.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id ?: -1,
        name = name ?: "",
        tagline = tagline ?: "",
        description = description ?: "",
        firstBrewed = first_brewed ?: "",
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}