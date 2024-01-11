package com.tanmay.starwarsprofiles.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.tanmay.starwarsprofiles.data.db.StarWarsDatabase
import com.tanmay.starwarsprofiles.data.models.Character
import com.tanmay.starwarsprofiles.data.network.StarWarsApi
import com.tanmay.starwarsprofiles.data.paging.SWProfileRemoteMediator
import javax.inject.Inject

class SWRepository @Inject constructor(
    private val db: StarWarsDatabase,
    private val api: StarWarsApi
) {

    @OptIn(ExperimentalPagingApi::class)
    suspend fun getPagedData(query: String): Pager<Int, Character> {
        return Pager(
            config = PagingConfig(pageSize = 50),
            remoteMediator = SWProfileRemoteMediator(
                query, db, api
            )
        ) {
            db.starWarsDao().getListOfSWProfiles()
        }


    }

}