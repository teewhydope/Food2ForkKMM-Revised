buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
        maven("https://jitpack.io")
    }
    dependencies {
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.buildTools)
        classpath(Build.sqlDelightGradlePlugin)
        classpath(Build.hiltGradlePlugin)
        classpath(Build.remalGradlePlugin)
        classpath(Build.mokoKSwiftGradlePlugin)
    }
}

apply(plugin = RemalDependencyCheck.remal)

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
