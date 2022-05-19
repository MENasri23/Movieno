package ir.jatlin.movieno

import android.app.Application
import timber.log.Timber


class MovienoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}