package com.tanmay.starwarsprofiles.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tanmay.starwarsprofiles.data.models.Character
import com.tanmay.starwarsprofiles.data.models.PeopleResponse

@Dao
interface StarWarsDao {

    @Query("SELECT COUNT(*) FROM Profiles")
    suspend fun getRowCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSWProfilesList(sneakers: List<Character>) : List<Long>

    @Query("SELECT * FROM Profiles")
    fun getListOfSWProfiles(): PagingSource<Int,Character>

    @Query("DELETE FROM Profiles")
    suspend fun deleteProfilesTable()


}