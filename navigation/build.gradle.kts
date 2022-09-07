plugins {
    androidLibrary(false)
    kotlinAndroid()
    parcelize()
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)

    defaultConfig {
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)

        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.fragmentKtx)
    implementation(Deps.Material.material)
    implementation(Deps.Timber.timber)
    implementation(Deps.Koin.koin)
    implementation(Deps.Koin.core)

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)
}