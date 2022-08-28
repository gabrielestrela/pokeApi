package com.star.common_kotlin.mapper

interface Mapper<in I, out O> {
    fun mapFrom(input: I): O
}
