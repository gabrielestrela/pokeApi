object Deps {
    object Kotlin {
        val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
        val coroutines by lazy {
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }
        val coroutinesCore by lazy {
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        }
    }

    object Koin {
        val koin by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
        val core by lazy { "io.insert-koin:koin-core:${Versions.koin}" }
        val koinTest by lazy { "io.insert-koin:koin-test:${Versions.koin}" }
        val kointJunit by lazy { "io.insert-koin:koin-test-junit4:${Versions.koin}" }
    }

    object AndroidX{
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
        val constraintLayout by lazy {
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        }
        val dataBinding by lazy {
            "androidx.databinding:databinding-common:${Versions.dataBinding}"
        }
        val fragmentKtx by lazy {
            "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
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
        val okhttp3 by lazy { "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}" }
    }

    object Ksp {
        val ksp by lazy { "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}" }
    }

    object Retrofit {
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
        val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}" }
    }

    object OkHttp3 {
        val loggerInterceptor by lazy {
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
        }
    }
}
