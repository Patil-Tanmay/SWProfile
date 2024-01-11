package com.tanmay.starwarsprofiles.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.tanmay.starwarsprofiles.data.db.StarWarsDatabase
import com.tanmay.starwarsprofiles.data.models.Character
import com.tanmay.starwarsprofiles.data.network.StarWarsApi


@OptIn(ExperimentalPagingApi::class)
class SWProfileRemoteMediator (
    private val query: String,
    private val database: StarWarsDatabase,
    private val networkService: StarWarsApi
) : RemoteMediator<Int, Character>() {
    val starWarsDao = database.starWarsDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Character>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )

                     state.pages.size + 1

                }
            }


            val response = networkService.getCharacters(loadKey ?: 0)

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    starWarsDao.deleteProfilesTable()
                }

                starWarsDao.insertSWProfilesList(response.results)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.next == null
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}