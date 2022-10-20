package es.pagamez.pokedex.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.pagamez.pokedex.data.local.converter.ImageConverter
import es.pagamez.pokedex.data.local.converter.StatConverter
import es.pagamez.pokedex.data.local.dao.PokemonDao
import es.pagamez.pokedex.data.local.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(
    ImageConverter::class,
    StatConverter::class
)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao

    companion object {
        val DB_NAME = "pokemon_db"
    }
}