plugins {
    androidApp(false)
    kotlinAndroid()
    ktLint()
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
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.Koin.koin)
    implementation(Deps.Koin.core)
    implementation(Deps.Timber.timber)

    implementation(project(":network"))
    implementation(project(":design-system"))
    implementation(project(":feature:pokedex:impl"))
    implementation(project(":feature:pokedex:publ"))
    implementation(project(":common-kotlin"))

    testImplementation(Deps.Junit.junit)
    testImplementation(Deps.Koin.kointJunit)
    testImplementation(Deps.Koin.koinTest)
    testImplementation(Deps.Mockk.mockk)
    androidTestImplementation(Deps.AndroidX.testExt)
    androidTestImplementation(Deps.AndroidX.testEspresso)
}
