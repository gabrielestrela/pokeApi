plugins {
    kotlin()
}

dependencies {
    implementation(Deps.Kotlin.coroutines)
    implementation(Deps.Kotlin.coroutinesCore)
    testImplementation(Deps.Mockk.mockk)
}
