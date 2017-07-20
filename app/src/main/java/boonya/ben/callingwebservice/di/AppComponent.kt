package boonya.ben.callingwebservice.di

import boonya.ben.callingwebservice.species.SpeciesListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oozou on 7/20/2017 AD.
 */

@Singleton
@Component(
        modules = arrayOf(
                ApiModule::class,
                SpeciesRepositoryModule::class
        )
)
interface AppComponent {

    fun inject(speciesListViewModel: SpeciesListViewModel)

}