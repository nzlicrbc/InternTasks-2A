buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(libs.nav.safe.args.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

