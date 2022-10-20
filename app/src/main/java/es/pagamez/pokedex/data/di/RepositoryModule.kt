package es.pagamez.pokedex.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.pagamez.pokedex.data.repository.PokemonRepositoryImpl
import es.pagamez.pokedex.domain.repository.PokemonRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(repository: PokemonRepositoryImpl): PokemonRepository = repository
}