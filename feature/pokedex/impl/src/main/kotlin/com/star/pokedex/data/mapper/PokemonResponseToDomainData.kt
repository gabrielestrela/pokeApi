package com.star.pokedex.data.mapper

import com.star.common_kotlin.mapper.Mapper
import com.star.common_kotlin.model.PokemonType
import com.star.common_kotlin.tools.orZero
import com.star.pokedex.data.response.PokedexListItemResponse
import com.star.pokedex.data.response.PokemonTypeResponse
import com.star.pokedex.domain.model.PokedexListItemData

class PokemonResponseToDomainData : Mapper<PokedexListItemResponse, PokedexListItemData> {
    override fun mapFrom(input: PokedexListItemResponse): PokedexListItemData =
        PokedexListItemData(
            pokedexNumber = input.pokedexIndex.orZero(),
            pokemonName = input.pokemonName.orEmpty(),
            types = parseTypes(input.typeList)
        )

    private fun parseTypes(input: List<PokemonTypeResponse>?): List<PokemonType> = input?.map {
        PokemonType.parse(it.typeInfo?.name.orEmpty())
    } ?: listOf()
}