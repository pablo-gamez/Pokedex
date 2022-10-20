package es.pagamez.pokedex.data.mapper

import es.pagamez.pokedex.data.local.model.ImageEntity
import es.pagamez.pokedex.data.local.model.PokemonEntity
import es.pagamez.pokedex.data.local.model.StatEntity
import es.pagamez.pokedex.data.remote.model.NameUrlDto
import es.pagamez.pokedex.data.remote.model.PokemonDto
import es.pagamez.pokedex.data.remote.model.SpritesDto
import es.pagamez.pokedex.data.remote.model.StatDto
import es.pagamez.pokedex.domain.model.Pokemon
import es.pagamez.pokedex.domain.model.PokemonItem
import javax.inject.Inject

class PokemonMapper @Inject constructor() {

    fun mapFromDto(dto: NameUrlDto) = PokemonItem(
        dto.name ?: "",
        dto.url ?: ""
    )

    fun mapFromDto(dto: PokemonDto) = with(dto) {
        Pokemon(
            id ?: 0,
            name ?: "",
            sprites?.toDomain() ?: Pokemon.ImagePack(),
            moves?.mapNotNull { it.move?.name } ?: emptyList(),
            height ?: 0,
            stats?.map { it.toDomain() } ?: emptyList(),
            types?.mapNotNull { it.type?.name }?.joinToString() ?: "",
            weight ?: 0
        )
    }

    private fun SpritesDto.toDomain() = Pokemon.ImagePack(
        other?.officialArtwork?.front_default,
        back_default,
        front_default,
        back_default,
    )

    private fun StatDto.toDomain() = Pokemon.Stat(
        stat?.name ?: "",
        base_stat ?: 0
    )

    fun mapFromEntity(entity: PokemonEntity) = with(entity) {
        Pokemon(
            id,
            name,
            with(images) {
                Pokemon.ImagePack(artwork, back, front, main)
            },
            moves,
            height,
            stats.map { Pokemon.Stat(it.name, it.value) },
            type,
            weight
        )
    }

    fun mapToEntity(domainModel: Pokemon) = with(domainModel) {
        PokemonEntity(
            id,
            name,
            with(images) {
                ImageEntity(artwork, back, front, main)
            },
            type,
            height,
            weight,
            moves,
            stats.map { StatEntity(it.name, it.value) }
        )
    }

}