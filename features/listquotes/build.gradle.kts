plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.9.20"
}
android {
    namespace = "com.besonganong.listquotesfeature"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {

        }
    }
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of("17"))
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {

    val composeBom = platform(libs.androidx.compose.bom)

    // listquotes feature does depend on app for app related settings like application Id.
    // app Module
    implementation(projects.app)

    // Kotlin Extension Libraries
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.ktx)

    // Ktor Libraries
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.engine)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.content.negotiation)

    // Compose Graphics (e.g Canvas)
    implementation(libs.androidx.compose.ui.graphics)

    // Compose Integration with Activities
    implementation(libs.activity.compose)

    // Compose Underlying Toolkit
    implementation(libs.androidx.compose.ui)

    // Compose Foundation
    implementation (libs.compose.foundation)

    // Compose Bill of Materials
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Compose Material Design 3
    implementation(libs.androidx.compose.material3)

    // Compose Android Studio Preview Support
    implementation(libs.androidx.composeui.tooling.preview)
    debugImplementation(libs.androidx.composeui.tooling)

    // Compose UI Tests
    androidTestImplementation(libs.androidx.composeui.test.junit4)
    debugImplementation(libs.androidx.composeui.test.manifest)
    // Unit Test
    testImplementation(libs.junit)

    // Integration Test
    androidTestImplementation(libs.androidx.junit)

    // Espresso Test
    androidTestImplementation(libs.androidx.test.espresso)

    // Annotation
    androidTestImplementation(libs.androidx.annotation)
    implementation(libs.androidx.annotation)
}