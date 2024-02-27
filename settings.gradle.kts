pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}
// Type-safe module/project dependencies
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Inspr"
include(":app")
include(":features:listquotes")
include(":navigation")
