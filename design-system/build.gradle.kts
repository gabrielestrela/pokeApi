plugins {
    androidLibrary(false)
    kotlinAndroid()
    kotlinKapt()
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
    implementation(Deps.AndroidX.dataBinding)
    implementation(Deps.Material.material)
    implementation(Deps.Timber.timber)
    implementation(Deps.Glide.glide)
    implementation(Deps.Glide.okhttp3)

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)

    kapt(Deps.Glide.compiler)
}