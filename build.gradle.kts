// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version(App.GRADLE_PLUGIN_VERSION).apply(false)
    id("com.android.library").version(App.GRADLE_PLUGIN_VERSION).apply(false)
    id("org.jetbrains.kotlin.android").version(App.KOTLIN_VERSION).apply(false)
    id("com.google.dagger.hilt.android").version(Libs.Hilt.version).apply(false)
    id("org.jetbrains.kotlin.jvm").version(App.KOTLIN_VERSION).apply(false)
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}
