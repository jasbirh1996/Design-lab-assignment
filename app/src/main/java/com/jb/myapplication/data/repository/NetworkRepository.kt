package com.jb.myapplication.data.repository

import com.jb.myapplication.data.network.Api
import com.jb.myapplication.data.network.model.DefineLabsResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val api : Api){
    suspend fun getDataFromServer():Response<DefineLabsResponse> = api.getData("40.7484,-73.9857","NPKYZ3WZ1VYMNAZ2FLX1WLECAWSMUVOQZOIDBN53F3LVZBPQ","20180616")
}