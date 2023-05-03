@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "sungbin.simplestatehistory"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin/")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.material3:material3:1.0.1")
}
