package boonya.ben.callingwebservice.species

import boonya.ben.callingwebservice.model.SpeciesList

/**
 * Created by oozou on 7/20/2017 AD.
 */
interface SpeciesRepository {

    fun getSpecies(successHandler: (SpeciesList?) -> Unit, failureHandler: (Throwable?) -> Unit)

}