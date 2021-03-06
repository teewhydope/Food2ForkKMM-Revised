buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
        maven("https://jitpack.io")
    }
    dependencies {

        with(Build) {
            classpath(kotlinGradlePlugin)
            classpath(buildTools)
            classpath(sqlDelightGradlePlugin)
            classpath(remalGradlePlugin)
            classpath(mokoKSwiftGradlePlugin)
        }
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
