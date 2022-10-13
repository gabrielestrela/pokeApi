package com.star.pokedex.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.star.common_android.koin.DependencyHandlerObserver
import com.star.common_kotlin.tools.whenNull
import com.star.pokedex.di.pokedexModule
import com.star.pokedex.impl.databinding.FragmentPokedexBinding
import com.star.pokedex.presentation.adapter.PokedexListAdapter

class PokedexFragment :
    Fragment(),
    LifecycleObserver by DependencyHandlerObserver(listOf(pokedexModule)) {

    private lateinit var binding: FragmentPokedexBinding
    private val pokedexListAdapter by lazy { PokedexListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentPokedexBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                binding = this
            }.also { viewLifecycleOwner.lifecycle.addObserver(this) }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        setupPokedexRecycler()
    }

    private fun setupPokedexRecycler() {
        with(binding.pokemonList) {
            adapter.whenNull { adapter = pokedexListAdapter }
        }
    }
}
