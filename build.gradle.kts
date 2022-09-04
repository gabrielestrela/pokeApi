
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    androidApp()
    androidLibrary()
    kotlinAndroidPlugin()
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.7.10"))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}