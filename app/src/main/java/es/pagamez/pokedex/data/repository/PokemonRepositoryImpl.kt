package es.pagamez.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import es.pagamez.pokedex.ConstAndValues
import es.pagamez.pokedex.data.local.datasource.LocalDatasource
import es.pagamez.pokedex.data.remote.paging.PokemonPagingDatasource
import es.pagamez.pokedex.data.remote.datasource.RemoteDatasource
import es.pagamez.pokedex.data.mapper.PokemonMapper
import es.pagamez.pokedex.domain.model.Pokemon
import es.pagamez.pokedex.domain.model.PokemonItem
import es.pagamez.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val local: LocalDatasource,
    private val remote: RemoteDatasource,
    private val paging: PokemonPagingDatasource,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override suspend fun getPokemonPagingList(): Flow<PagingData<PokemonItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = ConstAndValues.NETWORK_PAGE_SIZE,
                prefetchDistance = 2
            ),
            initialKey = ConstAndValues.STARTING_PAGE_INDEX,
            pagingSourceFactory = { paging }
        ).flow.map { data ->
            data.map { mapper.mapFromDto(it) }
        }
    }

    override suspend fun getPokemon(name: String): Pokemon? {
        val pokemon = local.getPokemon(name)
        return if (pokemon != null) {
            mapper.mapFromEntity(pokemon)
        } else {
            return remote.getPokemon(name).getOrNull()?.let { dto ->
                mapper.mapFromDto(dto).also {
                    local.addPokemon(mapper.mapToEntity(it))
                }
            }
        }
    }


}