plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)

    defaultConfig {
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)

        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    buildFeatures {
        dataBinding = true
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

    implementation(project(":design-system"))

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)
    androidTestImplementation(Deps.AndroidX.testEspresso)

    kapt(Deps.Moshi.codeGen)
    kapt(Deps.Glide.compiler)
}