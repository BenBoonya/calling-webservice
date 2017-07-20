package boonya.ben.callingwebservice.di

import boonya.ben.callingwebservice.species.SpeciesRepository
import boonya.ben.callingwebservice.species.SpeciesRepositoryImpl
import com.ben.boonya.architecturecomponentdemo.common.api.Swapi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by oozou on 7/20/2017 AD.
 */
@Module
class SpeciesRepositoryModule {

    @Provides @Singleton
    fun providePostRepository(apiService: Swapi): SpeciesRepository = SpeciesRepositoryImpl(apiService)
}