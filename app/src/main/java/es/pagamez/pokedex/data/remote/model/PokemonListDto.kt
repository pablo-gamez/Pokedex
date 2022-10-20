package es.pagamez.pokedex.data.remote.model

data class PokemonListDto(
    val count: Int? = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<NameUrlDto> = emptyList()
)