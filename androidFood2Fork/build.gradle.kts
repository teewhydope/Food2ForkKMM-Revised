plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(RemalDependencyCheck.remal)
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":common"))

    implementation(AndroidX.appCompat)

    implementation(Coil.coilCompose)

    implementation(Compose.activity)
    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.navigation)
    implementation(Compose.ui)
    implementation(Compose.viewmodel)
    implementation(Compose.windowSize)

    implementation(Di.popKorn)

    implementation(Google.material)

    implementation(Kotlinx.datetime)
    implementation(Ktor.android)

    androidTestImplementation(Tests.espresso)
    testImplementation(Tests.junit)
    androidTestImplementation(Tests.junitExt)

    debugImplementation(SquareUp.leakCanary)
}
