plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
}
android {
    namespace = "com.example.mymuscleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mymuscleapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        kotlinCompilerExtensionVersion = "1.4.2"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    //implementation Compose
    implementation ("androidx.activity:activity-compose:1.8.0")
    implementation ("androidx.compose.material:material:1.5.4")
    implementation ("androidx.compose.animation:animation:1.5.4")
    implementation ("androidx.compose.ui:ui-tooling:1.5.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime:2.3.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.2.2")
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.1")
    //Implementation Ktor
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("io.ktor:ktor-client-android:2.3.5")
    implementation("io.ktor:ktor-client-serialization:2.3.5")
    implementation("io.ktor:ktor-client-logging:2.3.5")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.5")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.5")
    // Koin for Kotlin apps
    implementation ("io.insert-koin:koin-ktor:3.5.0")
    implementation ("io.insert-koin:koin-logger-slf4j:3.5.0")
    implementation ("io.insert-koin:koin-android:3.5.0")
    implementation("io.insert-koin:koin-androidx-compose:3.5.0")

    implementation ("com.squareup.picasso:picasso:2.71828")

}