package com.jb.myapplication.data.localDb


import android.location.Location
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jb.myapplication.data.network.model.DefineLabsResponse
import java.lang.reflect.Type

class TypeConvertor {

    @TypeConverter
    fun toJson(mList: DefineLabsResponse.Location): String {
        return Gson().toJson(mList)

    }

    @TypeConverter
    fun toGson(data: String): DefineLabsResponse.Location {
        val type: Type = object : TypeToken<DefineLabsResponse.Location>() {}.type
        return Gson().fromJson(data, type)
    }
}