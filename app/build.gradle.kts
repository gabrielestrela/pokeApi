plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

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
    implementation(Deps.Material.material)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.Koin.koin)
    implementation(Deps.Timber.timber)
    implementation(Deps.Moshi.moshi)
    implementation(Deps.Glide.glide)

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)
    androidTestImplementation(Deps.AndroidX.testEspresso)

    kapt(Deps.Moshi.codeGen)
    kapt(Deps.Glide.compiler)
}