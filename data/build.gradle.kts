plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = App.COMPILE_SDK

    defaultConfig {
        minSdk = App.MIN_SDK
        targetSdk = App.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        buildTypes {
             create("staging") {
                initWith(getByName("debug"))
                matchingFallbacks.add("debug")
            }
        }

        sourceSets {
            getByName("staging") {
                java.srcDir("src/release/java")
            }
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
    implementation(project(":model"))
    implementation(project(":webservice"))
    implementation(project(":core-data"))

    // coroutine
    implementation(Libs.Kotlinx.COROUTINES_ANDROID)

    // hilt
    implementation(Libs.Hilt.HILT)
    kapt(Libs.Hilt.HILT_COMPILER)
    kapt(Libs.Hilt.ANDROIDX_HILT_COMPILER)

    // gson
    implementation(Libs.Retrofit.GSON)
    implementation(Libs.Retrofit.RETROFIT2)
}