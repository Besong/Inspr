

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.besonganong.inspr"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.besonganong.inspr"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {  }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dynamicFeatures += setOf(":features:listquotes")
}

    dependencies {

        val composeBom = platform(libs.androidx.compose.bom)

        // Module listquotes
        implementation(project(path = ":features:listquotes", configuration = "default"))

        // Kotlin Extension Libraries
        implementation(libs.lifecycle.runtime.ktx)
        implementation(libs.androidx.core.ktx)

        // Coroutines Support
        implementation(libs.ktx.coroutines.android)

        // Unit Test
        testImplementation(libs.junit)

        // Integration Test
        androidTestImplementation(libs.androidx.junit)

        //Espresso Test
        androidTestImplementation(libs.androidx.test.espresso)

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


    }