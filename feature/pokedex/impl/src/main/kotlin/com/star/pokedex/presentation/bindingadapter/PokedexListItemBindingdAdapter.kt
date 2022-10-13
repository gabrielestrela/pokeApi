package com.star.pokedex.presentation.bindingadapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.star.designsystem.extensions.getColor
import com.star.designsystem.extensions.getDrawable
import com.star.pokedex.presentation.model.PokedexNumberUi
import com.star.pokedex.presentation.model.PokemonTypeUi

@BindingAdapter("pokedexNumber")
fun TextView.configurePokedexNumber(number: PokedexNumberUi?) {
    number?.let {
        text = it.pokedexNumber
        setTextColor(getColor(it.pokedexNumberColor))
    }
}

@BindingAdapter("pokemonType")
fun TextView.configurePokemonType(type: PokemonTypeUi?) {
    type?.let { pokemonType ->
        text = pokemonType.type.text
        background = getDrawable(type.chipBackground)
    }
}

@BindingAdapter("pokemonImage")
fun AppCompatImageView.configurePokemonImage(@DrawableRes resource: Int?) {
    resource?.let {
        background = getDrawable(resource)
    }
}

@BindingAdapter("pokemonCardBackground")
fun ViewGroup.configureCardBackground(@DrawableRes resource: Int?) {
    resource?.let {
        background = getDrawable(it)
    }
}