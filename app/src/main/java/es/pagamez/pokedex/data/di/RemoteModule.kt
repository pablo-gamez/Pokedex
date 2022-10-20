package es.pagamez.pokedex.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.pagamez.pokedex.data.remote.datasource.RemoteDatasource
import es.pagamez.pokedex.data.remote.datasource.RemoteDatasourceImpl

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideRemoteDatasource(datadource: RemoteDatasourceImpl): RemoteDatasource = datadource
}