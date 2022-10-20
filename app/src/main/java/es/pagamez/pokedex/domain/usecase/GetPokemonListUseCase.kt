package es.pagamez.pokedex.domain.usecase

import androidx.paging.PagingData
import es.pagamez.pokedex.domain.model.PokemonItem
import kotlinx.coroutines.flow.Flow

fun interface GetPokemonListUseCase : suspend () -> Flow<PagingData<PokemonItem>>
