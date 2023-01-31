pluginManagement {
    includeBuild("build-logic")
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
}
rootProject.name = "JetpackCompose"
include(":demo")
include(":state-example")
include(":comp-local-demo")
include(":slot-api-demo")
include(":modifier-demo")
include(":row-col-demo")
include(":boxlayout")
include(":layout-modifier")
include(":constraintlayout")
include(":list-demo")
