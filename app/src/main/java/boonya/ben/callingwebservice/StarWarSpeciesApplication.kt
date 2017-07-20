package boonya.ben.callingwebservice

import android.app.Application
import boonya.ben.callingwebservice.di.ComponentInjector

/**
 * Created by oozou on 7/20/2017 AD.
 */
class StarWarSpeciesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentInjector.init()
    }
}