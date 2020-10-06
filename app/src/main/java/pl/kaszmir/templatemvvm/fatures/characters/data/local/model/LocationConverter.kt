package pl.kaszmir.templatemvvm.fatures.characters.data.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

class LocationConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: Location): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): Location {
            return Gson().fromJson(json, object : TypeToken<Location>() {}.type)
        }
    }

}