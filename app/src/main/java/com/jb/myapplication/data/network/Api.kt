package com.jb.myapplication.data.network

import com.jb.myapplication.data.network.model.DefineLabsResponse

import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query

interface Api {

    @GET("v2/venues/search")
   suspend fun getData(
        @Query("ll") ll: String,
        @Query("oauth_token") oauth_token: String,
        @Query("v") v: String

    ): Response<DefineLabsResponse>
}