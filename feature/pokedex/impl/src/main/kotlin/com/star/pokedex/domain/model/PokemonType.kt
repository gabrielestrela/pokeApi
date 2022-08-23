package com.star.pokedex.domain.model

enum class PokemonType(val type: String) {
    GRASS("grass"),
    FIRE("fire"),
    NORMAL("normal"),
    WATER("water"),
    POISON("poison"),
    FIGHTER("fighter"),
    FLYING("flying"),
    GROUND("ground"),
    ROCK("rock"),
    BUG("bug"),
    GHOST("ghost"),
    STEEL("steel"),
    ELECTRIC("electric"),
    PSYCHIC("psychic"),
    ICE("ice"),
    DRAGON("dragon"),
    DARK("dark"),
    FAIRY("fairy"),
    NONE("none");

    companion object Parser {
        fun parse(
            type: String,
            defaultValue: PokemonType = PokemonType.NONE
        ): PokemonType =
            values().find {
                it.type.toLowerCase() == type.toLowerCase()
            } ?: defaultValue
    }
}