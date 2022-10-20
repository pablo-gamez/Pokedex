package es.pagamez.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("game_indices")
    val games: List<GameDto>? = emptyList(),
    val height: Int? = null,
    val id: Int? = null,
    val moves: List<MoveDto>? = null,
    val name: String? = null,
    val order: Int? = null,
    val sprites: SpritesDto? = null,
    val stats: List<StatDto>? = emptyList(),
    val types: List<TypeDto>? = emptyList(),
    val weight: Int? = null
)