package es.pagamez.pokedex.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "images")
    val images: ImageEntity,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "height")
    val height: Int,

    @ColumnInfo(name = "weight")
    val weight: Int,

    @ColumnInfo(name = "moves")
    val moves: List<String>,

    @ColumnInfo(name = "stats")
    val stats: List<StatEntity>
)