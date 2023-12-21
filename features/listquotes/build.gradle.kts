plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
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
}

dependencies {
    // listquotes feature does depend on app for app related settings like application Id.
    //implementation(project(":app"))
    implementation(projects.app)
    // implementation "androidx.core:core-ktx:1.12.0"
    implementation(libs.androidx.core.ktx)
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0-RC")
    implementation(libs.ktx.coroutines.android)
    //implementation("io.ktor:ktor-client-core:2.3.7")
    implementation(libs.ktor.client.core)
    //implementation("io.ktor:ktor-client-cio:2.3.7")
    implementation(libs.ktor.client.engine)
    //testImplementation("junit:junit:4.13.2")
    testImplementation(libs.junit)
    //androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation(libs.androidx.junit)
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(libs.androidx.test.espresso)
    //androidTestImplementation("androidx.annotation:annotation:1.6.0")
    androidTestImplementation(libs.androidx.annotation)
    implementation(libs.androidx.annotation)
}