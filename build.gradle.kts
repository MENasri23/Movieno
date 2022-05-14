// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.2.0").apply(false)
    id("com.android.library").version("7.2.0").apply(false)
    id("org.jetbrains.kotlin.android").version("1.6.20").apply(false)
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}
