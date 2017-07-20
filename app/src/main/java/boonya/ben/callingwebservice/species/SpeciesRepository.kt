package boonya.ben.callingwebservice.species

import boonya.ben.callingwebservice.model.Species

/**
 * Created by oozou on 7/20/2017 AD.
 */
interface SpeciesRepository {

    fun getSpecies(successHandler: (List<Species>?) -> Unit, failureHandler: (Throwable?) -> Unit)

}