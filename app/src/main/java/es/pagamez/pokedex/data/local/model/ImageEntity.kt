package es.pagamez.pokedex.data.local.model

import androidx.room.ColumnInfo

data class ImageEntity(
    @ColumnInfo(name = "artwork")
    val artwork: String?,

    @ColumnInfo(name = "back")
    val back: String?,

    @ColumnInfo(name = "front")
    val front: String?,

    @ColumnInfo(name = "main")
    val main: String?
)
