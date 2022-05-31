package com.jb.myapplication.data.localDb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.jb.myapplication.data.localDb.Dao
import com.jb.myapplication.data.localDb.entity.MatchesEntity
import com.jb.myapplication.data.network.model.DefineLabsResponse

@Database(
entities = [MatchesEntity::class, DefineLabsResponse.Response.Venue::class],
    version = 1
)
@TypeConverters(TypeConvertor::class)
abstract class Db : RoomDatabase() {

    abstract fun matchesDao() : Dao

}