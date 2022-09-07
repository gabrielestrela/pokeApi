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

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(Deps.Kotlin.kotlin)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.Material.material)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.Koin.koin)
    implementation(Deps.Timber.timber)
    implementation(Deps.Moshi.moshi)
    implementation(Deps.Glide.glide)
    implementation(Deps.Retrofit.retrofit)

    implementation(project(":design-system"))
    implementation(project(":network"))
    implementation(project(":navigation"))
    implementation(project(":common-kotlin"))
    implementation(project(":common-android"))

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)
    androidTestImplementation(Deps.AndroidX.testEspresso)
}