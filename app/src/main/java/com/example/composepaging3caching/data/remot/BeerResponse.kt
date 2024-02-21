package com.example.composepaging3caching.data.remot


data class BeerResponse(
    val id: Int? = -1,
    val name: String? = "",
    val tagline: String? = "",
    val description: String? = "",
    val first_brewed: String? = "",
    val image_url: String? = ""
)
