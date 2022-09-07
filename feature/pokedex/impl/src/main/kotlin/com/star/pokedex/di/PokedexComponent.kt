package com.star.pokedex.di

import com.star.common_android.cache.Cache
import com.star.common_kotlin.mapper.Mapper
import com.star.common_kotlin.network.Service
import com.star.navigation.core.Navigator
import com.star.pokedex.data.api.AppPokedexApi
import com.star.pokedex.data.api.PokedexApi
import com.star.pokedex.data.datasource.PokedexDataSource
import com.star.pokedex.data.datasource.local.PokedexCache
import com.star.pokedex.data.datasource.local.PokedexLocalDataSource
import com.star.pokedex.data.datasource.remote.PokedexRemoteDataSource
import com.star.pokedex.data.mapper.PokemonResponseToDomainData
import com.star.pokedex.data.repository.AppPokedexRepository
import com.star.pokedex.data.repository.PokedexRepository
import com.star.pokedex.data.response.PokedexListItemResponse
import com.star.pokedex.domain.model.PokedexListItemData
import com.star.pokedex.presentation.navigation.PokedexNavigator
import com.star.pokedex.presentation.viewmodel.PokedexViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val LOCAL_DS = "LOCAL_DS"
private const val REMOTE_DS = "REMOTE_DS"
const val POKEDEX_NAV = "POKEDEX_NAV"

val pokedexModule = module {
    single<Cache<String, PokedexListItemResponse>> { PokedexCache() }
    factory<PokedexDataSource>(named(LOCAL_DS)) {
        PokedexLocalDataSource(pokedexCache = get())
    }

    factory<Service<PokedexApi>> { AppPokedexApi(get()) }

    factory<PokedexDataSource>(named(REMOTE_DS)) {
        PokedexRemoteDataSource(network = get(), apiService = get())
    }

    factory<Mapper<PokedexListItemResponse, PokedexListItemData>> {
        PokemonResponseToDomainData()
    }

    factory<PokedexRepository> {
        AppPokedexRepository(
            remoteDataSource = get(named(REMOTE_DS)),
            localDataSource = get(named(LOCAL_DS)),
            responseToDomainData = get()
        )
    }

    viewModel {
        PokedexViewModel()
    }
}

val pokedexNavigationModule = module {
    factory<Navigator>(named(POKEDEX_NAV)) { PokedexNavigator(androidContext()) }
}
