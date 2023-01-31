plugins {
    `kotlin-dsl`
}

group = "dev.project.eunmin.build.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "jetpack.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "jetpack.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "jetpack.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}