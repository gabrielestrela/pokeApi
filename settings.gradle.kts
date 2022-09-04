pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "pokeApi"
include(
    ":app",
    ":design-system",
    ":common-kotlin",
    ":common-android",
    ":network",
    ":feature:pokedex:impl",
    ":feature:pokedex:publ",
)
