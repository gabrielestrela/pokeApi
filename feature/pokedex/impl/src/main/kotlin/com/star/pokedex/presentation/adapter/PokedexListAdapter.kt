package com.star.pokedex.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.star.common_android.viewbinding.adapters.recyclerview.BindableRecyclerAdapter
import com.star.pokedex.impl.databinding.PokedexPokemonListItemBinding
import com.star.pokedex.presentation.model.PokedexListItemUi

class PokedexListAdapter :
    ListAdapter<PokedexListItemUi, PokedexListAdapter.PokedexItemViewHolder>(
        PokedexListDiffAdapter()
    ), BindableRecyclerAdapter<List<PokedexListItemUi>> {

    private val pokemonList: MutableList<PokedexListItemUi> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexItemViewHolder =
        PokedexItemViewHolder(parent)

    override fun onBindViewHolder(holder: PokedexItemViewHolder, position: Int) {
        holder.bind(pokemonList[position], position)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun setContent(content: List<PokedexListItemUi>) {
        pokemonList.clear()
        pokemonList.addAll(content)
        submitList(pokemonList)
    }

    inner class PokedexItemViewHolder private constructor(
        private val binding: PokedexPokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        constructor(parentView: ViewGroup) : this(
            PokedexPokemonListItemBinding.inflate(
                LayoutInflater.from(parentView.context),
                parentView,
                false
            )
        )

        fun bind(data: PokedexListItemUi, position: Int) {
            binding.data = data
        }
    }
}

internal class PokedexListDiffAdapter : DiffUtil.ItemCallback<PokedexListItemUi>() {
    override fun areItemsTheSame(oldItem: PokedexListItemUi, newItem: PokedexListItemUi): Boolean =
        oldItem.pokedexNumberUi  == newItem.pokedexNumberUi

    override fun areContentsTheSame(
        oldItem: PokedexListItemUi,
        newItem: PokedexListItemUi
    ): Boolean = oldItem == newItem
}
