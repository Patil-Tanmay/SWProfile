package com.tanmay.starwarsprofiles.data.models

import androidx.room.Entity
import com.squareup.moshi.Json

data class PeopleResponse(
    @Json(name="count")
    val count: Int,
    @Json(name="next")
    val next: String?=null,
    @Json(name="previous")
    val previous: String?=null,
    @Json(name="results")
    val results: List<Character>
)