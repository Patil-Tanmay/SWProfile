package com.tanmay.starwarsprofiles.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
//@TypeConverters(Converters::class)
abstract class StarWarsDatabase : RoomDatabase(){
    abstract fun starWarsDao(): StarWarsDao
}