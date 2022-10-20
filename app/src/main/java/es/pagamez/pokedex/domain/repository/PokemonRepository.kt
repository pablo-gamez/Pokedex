package es.pagamez.pokedex.domain.repository

import androidx.paging.PagingData
import es.pagamez.pokedex.domain.model.Pokemon
import es.pagamez.pokedex.domain.model.PokemonItem
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonPagingList(): Flow<PagingData<PokemonItem>>
    suspend fun getPokemon(name: String): Pokemon?

}