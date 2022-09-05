package com.star.pokedex.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.star.common_android.koin.DependencyHandlerObserver
import com.star.pokedex.impl.databinding.FragmentPokedexBinding

class PokedexFragment :
    Fragment(),
    LifecycleObserver by DependencyHandlerObserver(listOf()) {

    private lateinit var binding: FragmentPokedexBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentPokedexBinding
            .inflate(inflater, container, false)
            .apply { binding = this }
            .also { viewLifecycleOwner.lifecycle.addObserver(this) }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
