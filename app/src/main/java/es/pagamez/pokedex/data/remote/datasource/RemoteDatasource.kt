package es.pagamez.pokedex.data.remote.datasource

import es.pagamez.pokedex.data.remote.model.PokemonDto
import es.pagamez.pokedex.data.remote.model.PokemonListDto

interface RemoteDatasource {

    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDto>

    suspend fun getPokemon(name: String): Result<PokemonDto>

}