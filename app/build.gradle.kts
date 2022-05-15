import Libs.Androidx.implementAppLibraries

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

buildscript {

    class CommonAndroidPlugin : Plugin<Project> {

        private val Project.android
            get() = extensions.getByType(com.android.build.gradle.BaseExtension::class)


        override fun apply(project: Project) {
            with(project) {
                applyPlugins()
                android.run {
                    defaultConfig {

                    }
                }
            }

        }

        private fun Project.applyPlugins() {
//        apply("com.android.library")
//        apply("org.jetbrains.kotlin.android")
        }
    }
}

android {
    compileSdk = App.COMPILE_SDK

    defaultConfig {
        applicationId = App.APPLICATION_ID
        minSdk = App.MIN_SDK
        targetSdk = App.TARGET_SDK
        versionCode = App.VERSION_CODE
        versionName = App.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {

    implementAppLibraries()

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}