plugins {
    kotlin()
    kotlinKapt()
}

dependencies {
    implementation(project(":common-kotlin"))

    implementation(Deps.Koin.koin)
    implementation(Deps.Koin.core)
    implementation(Deps.Timber.timber)
    implementation(Deps.Kotlin.coroutines)
    implementation(Deps.Kotlin.coroutinesCore)
    implementation(Deps.Moshi.moshi)
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.moshiConverter)
    implementation(Deps.OkHttp3.loggerInterceptor)

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)

    kapt(Deps.Moshi.codeGen)
}
