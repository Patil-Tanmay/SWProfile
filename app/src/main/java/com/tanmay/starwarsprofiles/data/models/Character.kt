package com.tanmay.starwarsprofiles.data.models

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Profiles")
@Parcelize
data class Character(
    @Json(name="birth_year")
    val birthYear: String,
    @Json(name="eye_color")
    val eyeColor: String,
    @Json(name="films")
    val films: List<String>,
    @Json(name="gender")
    val gender: String,
    @Json(name="hair_color")
    val hairColor: String,
    @Json(name="height")
    val height: String,
    @Json(name="homeworld")
    val homeworld: String,
    @Json(name="mass")
    val mass: String,
    @Json(name="name")
    val name: String,
    @Json(name="skin_color")
    val skinColor: String
) : Parcelable