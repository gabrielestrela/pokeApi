import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

fun PluginDependenciesSpec.androidApp(
    includeVersion: Boolean = true
): PluginDependencySpec =
    id(PluginConfig.androidApplication).also {
        if (includeVersion) it.version(Versions.androidApplicationPlugin).apply(false)
    }

fun PluginDependenciesSpec.androidLibrary(
    includeVersion: Boolean = true
): PluginDependencySpec =
    id(PluginConfig.androidLibrary).also {
        if (includeVersion) it.version(Versions.androidLibrary).apply(false)
    }

fun PluginDependenciesSpec.kotlinAndroidPlugin(
    includeVersion: Boolean = true
): PluginDependencySpec =
    id(PluginConfig.pluginId).also {
        if (includeVersion) it.version(Versions.kotlinAndroid).apply(false)
    }

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
    kotlin(PluginConfig.pluginKotlinAndroid)

fun PluginDependenciesSpec.kotlin(): PluginDependencySpec = id(PluginConfig.pluginKotlin)

fun PluginDependenciesSpec.kotlinKapt(): PluginDependencySpec = kotlin(PluginConfig.kapt)

fun PluginDependenciesSpec.parcelize(): PluginDependencySpec = id(PluginConfig.parcelize)

fun PluginDependenciesSpec.ktLint(includeVersion: Boolean = true): PluginDependencySpec =
    id(PluginConfig.ktLint).also { if (includeVersion) it.version(Versions.ktLint) }