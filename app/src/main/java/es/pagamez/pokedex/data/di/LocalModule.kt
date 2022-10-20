package es.pagamez.pokedex.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.pagamez.pokedex.data.local.datasource.LocalDatasource
import es.pagamez.pokedex.data.local.datasource.LocalDatasourceImpl

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideLocalDatasource(datadource: LocalDatasourceImpl): LocalDatasource = datadource
}