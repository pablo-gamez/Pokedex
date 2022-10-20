package es.pagamez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import es.pagamez.pokedex.data.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonEntity): Long

    @Query("SELECT * FROM pokemon WHERE name = :name")
    suspend fun getPokemon(name: String): PokemonEntity?

}