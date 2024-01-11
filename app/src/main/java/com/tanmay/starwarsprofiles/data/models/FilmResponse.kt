package com.tanmay.starwarsprofiles.data.models

import com.squareup.moshi.Json

data class FilmResponse(
    @Json(name="opening_crawl")
    val openingCrawl: String,
    @Json(name="title")
    val title: String
)