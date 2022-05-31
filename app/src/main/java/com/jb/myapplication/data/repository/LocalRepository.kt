package com.jb.myapplication.data.repository

import com.jb.myapplication.data.localDb.Dao
import com.jb.myapplication.data.network.model.DefineLabsResponse
import javax.inject.Inject

class LocalRepository @Inject constructor(private val dao : Dao){

    suspend fun saveResponse(data : DefineLabsResponse.Response.Venue){
        dao.saveResponse(data)
    }

    suspend fun getAllSavedData (): List<DefineLabsResponse.Response.Venue>{
        return dao.getAllSavedData()
    }

    suspend fun updateMatch(value : Int,id:String){
        dao.updateMatches(value,id)
    }
    suspend fun getSelectedMatches ():List<DefineLabsResponse.Response.Venue>{
       return dao.getSelectedMatches()
    }
}