package com.jb.myapplication.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class DefineLabsResponse(
    val response: Response
){
    data class Response(
        val venues: List<Venue>
    ){

        @Entity
        data class Venue(
            @PrimaryKey
            val id: String,
            val location: Location,
            val name: String,
            val isSelected : Int = 0
            )
    }

    data class Location(
        val address: String,
        val state: String
    )


}