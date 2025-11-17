import java.util.Properties

val versionProps = Properties().apply {
    load(rootProject.file("version.properties").inputStream())
}

plugins {
    alias(libs.plugins.android.library)
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    id("maven-publish")
}

android {
    namespace = "br.com.lithiumcode.analytics_sdk"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
}
configurations.all {
    resolutionStrategy {
        // Use the newest version (e.g., 23.0.0)
        force("com.google.android.gms:play-services-measurement-base:23.0.0")
        force("com.google.android.gms:play-services-measurement-impl:23.0.0")
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.GilsonBezerra"
            artifactId = "AnalyticsSDK"
            version = versionProps["VERSION_NAME"].toString()

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.play.services.measurement.api)
    val composeBom = platform("androidx.compose:compose-bom:2024.10.00")
    implementation(composeBom)

    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
