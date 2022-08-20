object Deps {
    object Koin {
        val koin by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
        val koinTest by lazy { "io.insert-koin:koin-test:${Versions.koin}" }
        val kointJunit by lazy { "io.insert-koin:koin-test-junit4:${Versions.koin}" }
    }

    object AndroidX{
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
        val constraintLayout by lazy {
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        }
        val testExt by lazy { "androidx.test.ext:junit:${Versions.testExt}" }
        val testEspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.testEspresso}" }
    }

    object Junit {
        val junit by lazy { "junit:junit:${Versions.junit}" }
    }

    object Material {
        val material by lazy { "com.google.android.material:material:${Versions.material}" }
    }

    object Mockk {
        val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    }

    object Timber {
        val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    }

    object Moshi {
        val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
        val codeGen by lazy { "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}" }
    }

    object Glide {
        val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
        val compiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glide}" }
    }

    object Ksp {
        val ksp by lazy { "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}" }
    }
}