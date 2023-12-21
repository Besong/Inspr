

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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dynamicFeatures += setOf(":features:listquotes")
}

    dependencies {

        //implementation ("androidx.core:core-ktx:1.12.0")
        implementation(libs.androidx.core.ktx)
        //implementation(project(":features:listquotes"))
        implementation(project(path = ":features:listquotes", configuration = "default"))
        //implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation(libs.lifecycle.runtime.ktx)
        //implementation("androidx.activity:activity-compose:1.7.2")
        implementation(libs.activity.compose)
        //implementation(platform("androidx.compose:compose-bom:2023.03.00"))
        implementation(platform(libs.androidx.compose.bom))
        //implementation("androidx.compose.ui:ui")
        implementation(libs.androidx.compose.ui)
        //implementation("androidx.compose.ui:ui-graphics")
        implementation(libs.androidx.compose.ui.graphics)
        //implementation("androidx.compose.ui:ui-tooling-preview")
        implementation(libs.androidx.composeui.tooling.preview)
        //implementation("androidx.compose.material3:material3")
        implementation(libs.androidx.compose.material3)
        //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0-RC")
        implementation(libs.ktx.coroutines.android)
        //testImplementation("junit:junit:4.13.2")
        testImplementation(libs.junit)
        //androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation(libs.androidx.junit)
        //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation(libs.androidx.test.espresso)
        //androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
        androidTestImplementation(platform(libs.androidx.compose.bom))
        //androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        androidTestImplementation(libs.androidx.composeui.test.junit4)
        //debugImplementation("androidx.compose.ui:ui-tooling")
        debugImplementation(libs.androidx.composeui.tooling)
        //debugImplementation("androidx.compose.ui:ui-test-manifest")
        debugImplementation(libs.androidx.composeui.test.manifest)
    }