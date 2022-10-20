package es.pagamez.pokedex.data.remote.api

import es.pagamez.pokedex.data.remote.model.PokemonDto
import es.pagamez.pokedex.data.remote.model.PokemonListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Int
    ): Response<PokemonListDto>


    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path(value = "name") name: String,
    ): Response<PokemonDto>

}