plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "kr.ac.uc.test_2025_05_19_k"
    compileSdk = 34

    defaultConfig {
        applicationId = "kr.ac.uc.test_2025_05_19_k"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}



dependencies {
    // Kotlin & Coroutines
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation(platform("androidx.compose:compose-bom:2024.05.00")) // 최신버전
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")



    debugImplementation("androidx.compose.ui:ui-tooling")


    // Jetpack Compose (BOM 안정 버전)
    implementation(libs.androidx.appcompat)

    // Lifecycle (2.6.1)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Activity Compose (1.7.2)
    implementation("androidx.activity:activity-compose:1.7.2")

    // Navigation Compose (2.6.0)
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // Hilt (2.47)
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-compiler:2.47")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Javapoet (1.13.0)
    implementation("com.squareup:javapoet:1.13.0")

    // Retrofit (2.9.0, 예시)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // 기타 (Coil, Accompanist 등 필요 시)
    implementation("io.coil-kt:coil-compose:2.2.2")
    // implementation("com.google.accompanist:accompanist-systemuicontroller:0.30.1") // 필요 시
    implementation("androidx.browser:browser:1.7.0")

    implementation ("com.google.accompanist:accompanist-permissions:0.34.0")
    implementation("com.google.android.gms:play-services-location:21.2.0")



}
