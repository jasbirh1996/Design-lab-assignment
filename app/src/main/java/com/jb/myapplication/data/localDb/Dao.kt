package com.jb.myapplication.data.localDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jb.myapplication.data.network.model.DefineLabsResponse

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun saveResponse(data : DefineLabsResponse.Response.Venue)

    @Query("SELECT * FROM Venue ")
   suspend fun getAllSavedData():List<DefineLabsResponse.Response.Venue>

    @Query("SELECT * FROM VENUE Where isSelected =:isSelect")
  suspend  fun getSelectedMatches(isSelect: Int = 1): List<DefineLabsResponse.Response.Venue>

    @Query("UPDATE Venue SET isSelected = :value Where id=:id")
   suspend fun updateMatches(value : Int,id:String)
}