package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CommonAndroidPlugin : Plugin<Project> {


//    private val Project.android
//        get() = extensions.getByType(com.android.build.gradle.BaseExtension::class)


    override fun apply(project: Project) {
        with(project) {
            applyPlugins()

        }

    }

    private fun Project.applyPlugins() {
//        apply("com.android.library")
//        apply("org.jetbrains.kotlin.android")
    }
}