package pl.kaszmir.templatemvvm.fatures.characters.data.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Origin

class OriginConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: Origin): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): Origin {
            return Gson().fromJson(json, object : TypeToken<Origin>() {}.type)
        }
    }
}