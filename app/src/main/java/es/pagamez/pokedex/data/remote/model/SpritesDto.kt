package es.pagamez.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName

data class SpritesDto(
    val back_default: String? = null,
    val back_female: String? = null,
    val back_shiny: String? = null,
    val back_shiny_female: String? = null,
    val front_default: String? = null,
    val front_female: String? = null,
    val front_shiny: String? = null,
    val front_shiny_female: String? = null,
    val other: Other? = null,
) {
    data class Other(
        val dream_world: DreamWorld? = null,
        @SerializedName("official-artwork")
        val officialArtwork: OfficialArtwork? = null
    ) {
        data class DreamWorld(
            val front_default: String? = null,
            val front_female: String? = null
        )

        data class OfficialArtwork(
            val front_default: String? = null
        )
    }
}