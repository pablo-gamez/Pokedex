package es.pagamez.pokedex.data.remote.datasource

import es.pagamez.pokedex.data.remote.api.PokemonApi
import es.pagamez.pokedex.data.remote.model.PokemonDto
import es.pagamez.pokedex.data.remote.model.PokemonListDto
import es.pagamez.pokedex.data.remote.apiCall
import javax.inject.Inject

class RemoteDatasourceImpl @Inject constructor(
    private val api: PokemonApi
) : RemoteDatasource {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDto> {
        return apiCall { api.getPokemonList(limit, offset) }
    }

    override suspend fun getPokemon(name: String): Result<PokemonDto> {
        return apiCall { api.getPokemon(name) }
    }

}