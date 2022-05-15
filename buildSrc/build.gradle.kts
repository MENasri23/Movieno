import org.gradle.kotlin.dsl.`kotlin-dsl`
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}


dependencies {
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation(gradleApi())
}