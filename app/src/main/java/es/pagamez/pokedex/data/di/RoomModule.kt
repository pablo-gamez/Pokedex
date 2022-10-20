package es.pagamez.pokedex.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.pagamez.pokedex.data.local.dao.PokemonDao
import es.pagamez.pokedex.data.local.database.PokemonDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            PokemonDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePokemonDao(database: PokemonDatabase): PokemonDao {
        return database.getPokemonDao()
    }

}