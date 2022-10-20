package es.pagamez.pokedex.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val images: ImagePack,
    val moves: List<String>,
    val height: Int,
    val stats: List<Stat>,
    val type: String,
    val weight: Int
) {
    data class ImagePack(
        val artwork: String? = null,
        val back: String? = null,
        val front: String? = null,
        val main: String? = null
    )

    data class Stat(
        val name: String,
        val value: Int
    )
}
