package boonya.ben.callingwebservice.di

import boonya.ben.callingwebservice.Const

class ComponentInjector {

    companion object {

        lateinit var component: AppComponent

        fun init() {
            component = DaggerAppComponent.builder()
                    .apiModule(ApiModule(Const.BASE_URL))
                    .speciesRepositoryModule(SpeciesRepositoryModule())
                    .build()
        }
    }
}

