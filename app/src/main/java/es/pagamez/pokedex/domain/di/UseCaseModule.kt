package es.pagamez.pokedex.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.pagamez.pokedex.domain.repository.PokemonRepository
import es.pagamez.pokedex.domain.usecase.GetPokemonListUseCase
import es.pagamez.pokedex.domain.usecase.GetPokemonUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPokemonListUseCase(repository: PokemonRepository) =
        GetPokemonListUseCase(repository::getPokemonPagingList)

    @Provides
    fun provideGetPokemonUseCase(repository: PokemonRepository) =
        GetPokemonUseCase(repository::getPokemon)

}