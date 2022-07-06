plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(RemalDependencyCheck.remal)
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.appId
        targetSdk = Application.targetSdk
        minSdk = Application.minSdk
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
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":common"))

    implementation(AndroidX.appCompat)

    implementation(Compose.activity)
    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.navigation)
    implementation(Compose.viewmodel)

    implementation(Google.material)

    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltNavigation)
    kapt(Hilt.hiltCompiler)

    implementation(Kotlinx.datetime)
    implementation(Ktor.android)

    androidTestImplementation(Tests.espresso)
    testImplementation(Tests.junit)
    androidTestImplementation(Tests.junitExt)

    debugImplementation(SquareUp.leakCanary)
}
