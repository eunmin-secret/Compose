plugins {
    id("jetpack.android.application")
    id("jetpack.android.application.compose")
    id("jetpack.android.hilt")
}

android {
    namespace = "dev.project.eunmin.demo"

    defaultConfig {
        applicationId = "dev.project.eunmin.demo"
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.compose.material)
    // or skip Material Design and build directly on top of foundational components
    implementation(libs.androidx.compose.foundation)
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation(libs.androidx.compose.ui)

    // Android Studio Preview support
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.compose.material.icons.core)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3.windowSizeClass)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
}