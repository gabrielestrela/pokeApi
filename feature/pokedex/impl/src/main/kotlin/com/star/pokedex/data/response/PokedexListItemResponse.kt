package com.star.pokedex.data.response

import com.squareup.moshi.Json
import java.io.Serializable

data class PokedexListItemResponse(
    @Json(name = "id") val pokedexIndex: Int?,
    @Json(name = "types") val typeList: List<PokemonTypeResponse>?,
    @Json(name = "name") val pokemonName: String?
) : Serializable

data class PokemonTypeResponse(
    @Json(name = "slot") val slot: Int?,
    @Json(name = "type") val typeInfo: BasicDataResponse?
) : Serializable

data class BasicDataResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "url") val url: String?
) : Serializable
