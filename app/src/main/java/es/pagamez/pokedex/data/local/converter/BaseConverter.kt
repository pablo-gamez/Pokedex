package es.pagamez.pokedex.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

abstract class BaseConverter<T> {
    @TypeConverter
    fun toModel(data: String?): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(data, type)
    }

    @TypeConverter
    fun fromModel(model: T): String = Gson().toJson(model)
}