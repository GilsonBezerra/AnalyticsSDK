pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/GilsonBezerra/AnalyticsSDK")
            credentials {
                username = System.getenv("GH_PACKAGES_USER")
                password = System.getenv("GH_PACKAGES_TOKEN")
            }
        }
    }
}

rootProject.name = "AnalyticsSDK"
include(":app")
include(":analytics-sdk")
