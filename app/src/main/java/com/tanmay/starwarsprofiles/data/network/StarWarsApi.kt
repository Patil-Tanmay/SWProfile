package com.tanmay.starwarsprofiles.data.network

import com.tanmay.starwarsprofiles.data.models.*
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsApi {

    @GET("people/?page/")
    suspend fun getCharacters(@Query("page") page: Int): PeopleResponse

    @GET
    suspend fun getFilm(@Url url: String): FilmResponse

}