package com.jb.myapplication.data.localDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchesEntity(
    @PrimaryKey
    val id : String
)
