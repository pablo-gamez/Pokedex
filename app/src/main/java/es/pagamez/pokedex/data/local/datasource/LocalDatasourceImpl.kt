package es.pagamez.pokedex.data.local.datasource

import es.pagamez.pokedex.data.local.dao.PokemonDao
import es.pagamez.pokedex.data.local.model.PokemonEntity
import javax.inject.Inject

class LocalDatasourceImpl @Inject constructor(
    private val dao: PokemonDao
) : LocalDatasource {

    override suspend fun addPokemon(pokemon: PokemonEntity): Long {
        return dao.insert(pokemon)
    }

    override suspend fun getPokemon(name: String): PokemonEntity? {
        return dao.getPokemon(name)
    }
}