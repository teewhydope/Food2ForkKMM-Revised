plugins {
    kotlin(KotlinPlugins.multiplatform)
    kotlin(KotlinPlugins.cocoapods)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(Plugins.androidLibrary)
    id(Plugins.sqlDelight)
    id(Plugins.mokoKswift)
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    // iosSimulatorArm64()
    jvm()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosFood2Fork/Podfile")
        framework {
            baseName = "MultiPlatformLibrary"
            isStatic = false

            export(Moko.mvvmCore)
            export(Moko.mvvmFlow)
        }
    }

    sourceSets {
        val commonMain by getting {
            configurations["kapt"].dependencies.add(project.dependencies.create(Di.popKornCompiler))
            kotlin.srcDir("build/generated/source/kaptKotlin")

            dependencies {
                implementation(Ktor.auth)
                implementation(Ktor.clientSerialization)
                implementation(Ktor.contentNegotiation)
                implementation(Ktor.core)

                api(Moko.mvvmCore)
                api(Moko.mvvmFlow)

                implementation(SQLDelight.runtime)

                implementation(Di.popKorn)

                implementation("androidx.startup:startup-runtime:1.1.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.android)
                implementation(SQLDelight.androidDriver)
                api(Moko.mvvmFlowCompose)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        // val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            // iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Ktor.ios)
                implementation(SQLDelight.nativeDriver)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        // val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            // iosSimulatorArm64Test.dependsOn(this)
        }

        val jvmMain by getting

        val jvmTest by getting {
            dependencies {
                implementation(Tests.mockito)
            }
        }
    }
}

android {
    packagingOptions {
        resources.merges.add("META-INF/popkorn.provider.mappings")
        resources.merges.add("META-INF/popkorn.resolver.mappings")
    }
    compileSdk = Application.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        targetSdk = Application.targetSdk
        minSdk = Application.minSdk
    }
    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    configurations {
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
}

sqldelight {
    database(name = "RecipeDataBase") {
        packageName = "com.teewhy.food2forkkmm.data.local"
        sourceFolders = listOf("sqldelight")
    }
}
