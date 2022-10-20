package es.pagamez.pokedex.domain.usecase

import es.pagamez.pokedex.domain.model.Pokemon

fun interface GetPokemonUseCase : suspend (String) -> Pokemon?