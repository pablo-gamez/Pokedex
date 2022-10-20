package es.pagamez.pokedex.data.local.datasource

import es.pagamez.pokedex.data.local.model.PokemonEntity

interface LocalDatasource {

    suspend fun addPokemon(pokemon: PokemonEntity): Long

    suspend fun getPokemon(name: String): PokemonEntity?

}